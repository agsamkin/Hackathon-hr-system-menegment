package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.RequiredExperienceDto;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.data.service.vacancy.iService.RequiredExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + RequiredExperienceController.REQUIRED_EXPERIENCE_CONTROLLER_PATH)
public class RequiredExperienceController {
    public static final String REQUIRED_EXPERIENCE_CONTROLLER_PATH = "/requiredExperience";
    public static final String ID = "/{id}";

    private final RequiredExperienceService requiredExperienceService;

    @GetMapping(ID)
    public RequiredExperience getWorkFormatById(@PathVariable("id") final long id) {
        return requiredExperienceService.getRequiredExperienceById(id);
    }

    @GetMapping()
    public List<RequiredExperience> getAllWorkFormats() {
        return requiredExperienceService.getAllRequiredExperiences();
    }

    @PostMapping()
    public RequiredExperience createWorkFormat(@RequestBody @Valid RequiredExperienceDto requiredExperienceDto) {
        return requiredExperienceService.createRequiredExperience(requiredExperienceDto);
    }
}
