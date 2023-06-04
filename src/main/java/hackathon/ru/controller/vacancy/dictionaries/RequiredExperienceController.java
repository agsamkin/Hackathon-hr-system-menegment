package hackathon.ru.controller.vacancy.dictionaries;

import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.service.vacancy.iService.RequiredExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Required Experience Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + RequiredExperienceController.REQUIRED_EXPERIENCE_CONTROLLER_PATH)
public class RequiredExperienceController {
    public static final String REQUIRED_EXPERIENCE_CONTROLLER_PATH = "/required-experiences";
    public static final String ID = "/{id}";

    private final RequiredExperienceService requiredExperienceService;

    @Operation(summary = "Get Required Experience by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Required Experience with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Required Experience with that id does not exist")
    })
    @GetMapping(ID)
    public RequiredExperience getRequiredExperienceById(@PathVariable("id") final long id) {
        return requiredExperienceService.getRequiredExperienceById(id);
    }

    @Operation(summary = "Get All Required Experiences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Required Experiences was successfully found"),
    })
    @GetMapping()
    public List<RequiredExperience> getAllRequiredExperiences() {
        return requiredExperienceService.getAllRequiredExperiences();
    }

}

