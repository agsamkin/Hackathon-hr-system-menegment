package hackathon.ru.controller.calendar;

import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Event;
import hackathon.ru.data.service.calendar.EventService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("${base-url}" + EventController.EVENT_CONTROLLER_PATH)
@RestController
public class EventController {
    public static final String EVENT_CONTROLLER_PATH = "/events";

    private final EventService eventService;

    @PostMapping
    public Event setUsersCalendar(@RequestBody EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }
}
