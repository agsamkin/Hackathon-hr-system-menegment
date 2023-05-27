package hackathon.ru.api.impl;

import hackathon.ru.api.CalendarApi;
import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.calendar.Event;

import java.util.List;

public class OutlookCalendarApi implements CalendarApi {
    @Override
    public List<Calendar> getCalendars(String oauth2token) {
        return null;
    }

    @Override
    public Event createEvent(String oauth2token, String calendarId, EventDto eventDto) {
        return null;
    }
}
