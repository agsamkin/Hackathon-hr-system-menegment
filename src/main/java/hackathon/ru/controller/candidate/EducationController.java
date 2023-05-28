package hackathon.ru.controller.candidate;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.service.candidate.iservice.EducationService;
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
@RequestMapping("${base-url}" + EducationController.EDUCATION_CONTROLLER_PATH)
public class EducationController {
    public static final String EDUCATION_CONTROLLER_PATH = "/educations";
    public static final String ID = "/{id}";
    private final EducationService educationService;


    // POST /api/candidates - добавление образования
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Create new education")
    @ApiResponse(responseCode = "201", description = "Education created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Education createDegree(
            @Parameter(schema = @Schema(implementation = EducationDto.class))
            @RequestBody @Valid EducationDto educationDto) {
        return educationService.createEducation(educationDto);
    }


    // PUT /api/candidates/{id} - обновление образования
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Update education by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Education updated"),
            @ApiResponse(responseCode = "404", description = "Education with this ID not found")
    })
    @PutMapping(ID)
    public Education updateCandidate(@PathVariable("id") final Long id,
                                  @RequestBody @Valid final EducationDto educationDto) {
        return educationService.updateEducation(id, educationDto);
    }
}
