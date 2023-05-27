package hackathon.ru.data.service.calendar.impl;

import hackathon.ru.api.CalendarApi;
import hackathon.ru.data.dto.calendar.TokenDto;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.repository.CalendarRepository;
import hackathon.ru.data.service.calendar.CalendarService;
import hackathon.ru.data.service.user.iService.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    private final UserService userService;
    private final CalendarApi calendarApi;

    @Override
    public Calendar getMainUsersCalendar(TokenDto tokenDto) {
        User user = userService.getCurrentUser();
        if (Objects.isNull(user) || user.getEmail().isEmpty()) {
            throw new RuntimeException("Current user not found");
        }
        List<Calendar> calendars = calendarApi.getCalendars(tokenDto.getOauth2token());
        return setMainUsersCalendar(user, calendars);
    }

    private Calendar setMainUsersCalendar(User user, List<Calendar> calendars) {
        Calendar mainCalendar = calendars.stream()
                .filter(c-> user.getEmail().equals(c.getCalendarId()))
                .findFirst().get();

        if (Objects.isNull(mainCalendar)) {
            return new Calendar();
        }

        Calendar existingCalendar = calendarRepository.getByCalendarId(mainCalendar.getCalendarId());
        if (Objects.nonNull(existingCalendar)) {
            existingCalendar.setSummery(mainCalendar.getSummery());
            existingCalendar.setDescription(mainCalendar.getDescription());
            existingCalendar.setUser(user);
            return calendarRepository.save(existingCalendar);
        } else {
            Calendar newCalendar = Calendar.builder()
                    .calendarId(mainCalendar.getCalendarId())
                    .summery(mainCalendar.getSummery())
                    .description(mainCalendar.getDescription())
                    .user(user).build();
            return calendarRepository.save(newCalendar);
        }
    }

    @Override
    public Calendar getCalendarById(long id) {
        return calendarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found"));
    }

    @Override
    public Calendar getCalendarByUserId(Long id) {
        return calendarRepository.findByUserId(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found"));
    }
}
