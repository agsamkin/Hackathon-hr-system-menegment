package hackathon.ru.data.service.calendar;

import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Event;

public interface EventService {
    Event createEvent(EventDto eventDto);
}
