package hackathon.ru.controller.candidate;

import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.DegreeDto;
import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.data.service.candidate.iservice.DegreeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Degree controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + DegreeController.DEGREE_CONTROLLER_PATH)
public class DegreeController {

    public static final String DEGREE_CONTROLLER_PATH = "/degrees";
    public static final String ID = "/{id}";
    private final DegreeService degreeService;


    // POST /api/candidates - добавление новой степени
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Create new degree")
    @ApiResponse(responseCode = "201", description = "Degree created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Degree createDegree(
            @Parameter(schema = @Schema(implementation = CandidateDto.class))
            @RequestBody @Valid DegreeDto degreeDto) {
        return degreeService.createDegree(degreeDto);
    }


    // PUT /api/candidates/{id} - обновление степени
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Update degree by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Degree updated"),
            @ApiResponse(responseCode = "404", description = "Degree with this ID not found")
    })
    @PutMapping(ID)
    public Degree updateCandidate(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final DegreeDto degreeDto) {
        return degreeService.updateDegree(id, degreeDto);
    }


}
