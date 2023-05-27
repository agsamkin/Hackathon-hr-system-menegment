package hackathon.ru.data.service.calendar.impl;

import hackathon.ru.api.CalendarApi;
import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Attendee;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.calendar.Event;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.repository.AttendeeRepository;
import hackathon.ru.data.repository.EventRepository;
import hackathon.ru.data.service.calendar.CalendarService;
import hackathon.ru.data.service.calendar.EventService;
import hackathon.ru.data.service.user.iService.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final CalendarApi calendarApi;
    private final UserService userService;
    private final AttendeeRepository attendeeRepository;
    private final CalendarService calendarService;

    @Override
    public Event createEvent(EventDto eventDto) {
        User user = userService.getCurrentUser();
        if (Objects.isNull(user)) {
            throw new RuntimeException("Current user not found");
        }

        Calendar calendar = calendarService.getCalendarByUserId(user.getId());
//        Calendar calendar = user.getCalendar();
        if (Objects.isNull(calendar)) {
            throw new RuntimeException("Users calendar not found");
        }

        Event event = calendarApi.createEvent(eventDto.getOauth2token(), calendar.getCalendarId(), eventDto);
        event.setCalendar(calendar);
        Event newEvent = eventRepository.save(event);

        for (Attendee attendee : newEvent.getAttendees()) {
            attendee.setEvent(event);
        }
        attendeeRepository.saveAll(event.getAttendees());

        return newEvent;
    }

}
