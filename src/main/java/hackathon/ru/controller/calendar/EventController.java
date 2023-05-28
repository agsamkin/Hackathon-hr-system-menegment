package hackathon.ru.controller.calendar;

import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Event;
import hackathon.ru.service.calendar.EventService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("${base-url}" + EventController.EVENT_CONTROLLER_PATH)
@RestController
public class EventController {
    public static final String EVENT_CONTROLLER_PATH = "/events";

    private final EventService eventService;
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @PostMapping
    public Event setUsersCalendar(@RequestBody EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }
}
