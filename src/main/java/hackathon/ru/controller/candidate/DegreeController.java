package hackathon.ru.controller.candidate;

import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.service.candidate.iservice.DegreeService;
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

@Tag(name = "Degree controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + DegreeController.DEGREE_CONTROLLER_PATH)
public class DegreeController {

    public static final String DEGREE_CONTROLLER_PATH = "/degrees";
    public static final String ID = "/{id}";
    private final DegreeService degreeService;

    @Operation(summary = "Get Degree by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Degree with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Degree with that id does not exist")
    })
    @GetMapping(ID)
    public Degree getDegreeById(@PathVariable("id") final Long id) {
        return degreeService.getDegreeById(id);
    }

    @Operation(summary = "Get All Degrees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Degree was successfully found"),
    })
    @GetMapping()
    public List<Degree> getAllDegrees() {
        return degreeService.getAllDegrees();
    }

}
