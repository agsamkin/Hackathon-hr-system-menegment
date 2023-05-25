package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.WorkFormatDto;
import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.data.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + WorkFormatController.WORK_FORMAT_CONTROLLER_PATH)
public class WorkFormatController {
    public static final String WORK_FORMAT_CONTROLLER_PATH = "/workFormats";
    public static final String ID = "/{id}";

    private final WorkFormatService workFormatService;


    @GetMapping(ID)
    public WorkFormat getWorkFormatById(@PathVariable("id") final long id) {
        return workFormatService.getWorkFormatById(id);
    }

    @GetMapping()
    public List<WorkFormat> getAllWorkFormats() {
        return workFormatService.getAllWorkFormats();
    }

    @PostMapping()
    public WorkFormat createWorkFormat(@RequestBody @Valid WorkFormatDto workFormatDto) {
        return workFormatService.createWorkFormat(workFormatDto);
    }

}
