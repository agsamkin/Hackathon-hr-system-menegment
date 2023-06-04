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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Education controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + EducationController.EDUCATION_CONTROLLER_PATH)
public class EducationController {
    public static final String EDUCATION_CONTROLLER_PATH = "/educations";
    public static final String ID = "/{id}";
    private final EducationService educationService;


    // POST /api/candidates - добавление образования
    @Operation(summary = "Create new Education")
    @ApiResponse(responseCode = "201", description = "User was successfully created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Education createEducation(
            @Parameter(schema = @Schema(implementation = EducationDto.class))
            @RequestBody @Valid EducationDto educationDto) {
        return educationService.createEducation(educationDto);
    }

    // PUT /api/candidates/{id} - обновление образования
    @Operation(summary = "Update Education by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Education with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "Education with that id does not exist")
    })
    @PutMapping(ID)
    public Education updateEducation(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final EducationDto educationDto) {
        return educationService.updateEducation(id, educationDto);
    }
}
