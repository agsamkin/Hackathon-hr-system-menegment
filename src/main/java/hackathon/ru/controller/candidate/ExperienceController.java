package hackathon.ru.controller.candidate;

import hackathon.ru.data.dto.candidate.ExperienceDto;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.service.candidate.iservice.ExperienceService;
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

@Tag(name = "Experience controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + ExperienceController.EXPERIENCE_CONTROLLER_PATH)
public class ExperienceController {

    public static final String EXPERIENCE_CONTROLLER_PATH = "/experiences";
    public static final String ID = "/{id}";
    private final ExperienceService experienceService;


    // POST /api/candidates - добавление места работы
    @Operation(summary = "Create new Experience")
    @ApiResponse(responseCode = "201", description = "User was successfully created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Experience createExperience(
            @Parameter(schema = @Schema(implementation = ExperienceDto.class))
            @RequestBody @Valid ExperienceDto experienceDto) {
        return experienceService.createExperience(experienceDto);
    }


    // PUT /api/candidates/{id} - обновление места работы
    @Operation(summary = "Update Experience by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Education with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "Education with that id does not exist")
    })
    @PutMapping(ID)
    public Experience updateExperience(@PathVariable("id") final Long id,
                                      @RequestBody @Valid final ExperienceDto experienceDto) {
        return experienceService.updateExperience(id, experienceDto);
    }


}
