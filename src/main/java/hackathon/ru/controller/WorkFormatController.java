package hackathon.ru.controller;

import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.data.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + WorkFormatController.WORK_FORMAT_CONTROLLER_PATH)
public class WorkFormatController {
    public static final String WORK_FORMAT_CONTROLLER_PATH = "/workFormats";
    public static final String ID = "/{id}";

    private final WorkFormatService workFormatService;


    @GetMapping(ID)
    public WorkFormat getVacanciesById(@PathVariable("id") final long id) {
        return workFormatService.getWorkFormatById(id);
    }

    @GetMapping()
    public List<WorkFormat> getAllVacancies() {
        return workFormatService.getAllWorkFormats();
    }

}
