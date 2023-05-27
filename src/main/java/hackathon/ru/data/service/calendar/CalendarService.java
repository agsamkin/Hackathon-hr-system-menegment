package hackathon.ru.data.service.calendar;

import hackathon.ru.data.dto.calendar.TokenDto;
import hackathon.ru.data.model.calendar.Calendar;

public interface CalendarService {
    Calendar getMainUsersCalendar(TokenDto tokenDto);
    Calendar getCalendarById(long id);
    Calendar getCalendarByUserId(Long id);
}
