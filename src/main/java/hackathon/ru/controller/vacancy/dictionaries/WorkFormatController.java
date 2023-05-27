package hackathon.ru.controller.vacancy.dictionaries;

import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + WorkFormatController.WORK_FORMAT_CONTROLLER_PATH)
public class WorkFormatController {
    public static final String WORK_FORMAT_CONTROLLER_PATH = "/work-formats";
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

}

