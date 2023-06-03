package hackathon.ru.controller.candidate;

import hackathon.ru.data.dto.candidate.ExperienceDto;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.service.candidate.iservice.ExperienceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Degree controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + ExperienceController.EXPERIENCE_CONTROLLER_PATH)
public class ExperienceController {

    public static final String EXPERIENCE_CONTROLLER_PATH = "/experiences";
    public static final String ID = "/{id}";
    private final ExperienceService experienceService;


    // POST /api/candidates - добавление места работы
    @PostMapping()
    @ResponseStatus(CREATED)
    public Experience createDegree(
            @Parameter(schema = @Schema(implementation = ExperienceDto.class))
            @RequestBody @Valid ExperienceDto experienceDto) {
        return experienceService.createExperience(experienceDto);
    }


    // PUT /api/candidates/{id} - обновление места работы
    @PutMapping(ID)
    public Experience updateCandidate(@PathVariable("id") final Long id,
                                      @RequestBody @Valid final ExperienceDto experienceDto) {
        return experienceService.updateExperience(id, experienceDto);
    }


}
