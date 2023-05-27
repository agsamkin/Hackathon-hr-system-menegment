package hackathon.ru.controller.calendar;

import hackathon.ru.data.dto.calendar.TokenDto;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.service.calendar.CalendarService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("${base-url}" + CalendarController.CALENDAR_CONTROLLER_PATH)
@RestController
public class CalendarController {
    public static final String CALENDAR_CONTROLLER_PATH = "/calendars";
    public static final String ID = "/{id}";

    private final CalendarService calendarService;

    @GetMapping
    public Calendar getMainUsersCalendar(@RequestBody TokenDto tokenDto) {
        return calendarService.getMainUsersCalendar(tokenDto);
    }

    @GetMapping(ID)
    public Calendar getCalendarById(@PathVariable("id") long id) {
        // TODO: Необходимо огранивать размер выборки, т.к. список Event может быть большим
        return calendarService.getCalendarById(id);
    }

}
