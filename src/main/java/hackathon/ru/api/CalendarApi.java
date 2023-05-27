package hackathon.ru.api;

import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.calendar.Event;

import java.util.List;

public interface CalendarApi {
    List<Calendar> getCalendars(String oauth2token);
    Event createEvent(String oauth2token, String calendarId, EventDto eventDto);
}
