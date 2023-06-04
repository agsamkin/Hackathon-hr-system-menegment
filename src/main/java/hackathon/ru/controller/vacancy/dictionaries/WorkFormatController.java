package hackathon.ru.controller.vacancy.dictionaries;

import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.service.vacancy.iService.WorkFormatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Work Format Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + WorkFormatController.WORK_FORMAT_CONTROLLER_PATH)
public class WorkFormatController {
    public static final String WORK_FORMAT_CONTROLLER_PATH = "/work-formats";
    public static final String ID = "/{id}";

    private final WorkFormatService workFormatService;

    @Operation(summary = "Get Work Format by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Work Format with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Work Format with that id does not exist")
    })
    @GetMapping(ID)
    public WorkFormat getWorkFormatById(@PathVariable("id") final long id) {
        return workFormatService.getWorkFormatById(id);
    }

    @Operation(summary = "Get All Work Formats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Work Formats was successfully found"),
    })
    @GetMapping()
    public List<WorkFormat> getAllWorkFormats() {
        return workFormatService.getAllWorkFormats();
    }

}

