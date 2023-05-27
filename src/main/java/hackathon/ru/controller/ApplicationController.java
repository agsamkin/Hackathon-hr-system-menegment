package hackathon.ru.controller;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.service.application.iService.ApplicationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Application controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + ApplicationController.APPLICATION_CONTROLLER_PATH)
public class ApplicationController {

    public static final String APPLICATION_CONTROLLER_PATH = "/applications";
    public static final String ID = "/{id}";
    public static final String HR = "/hr";
    private final ApplicationService applicationService;

    // GET /api/applications/{id} - получение кандидата по идентификатору
    @GetMapping(ID)
    public Application getApplicationById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationById(id);
    }


    // POST /api/applications - создание нового кандидата
    @PostMapping()
    @ResponseStatus(CREATED)
    public Application createApplication(
            @Parameter(schema = @Schema(implementation = ApplicationDto.class))
            @RequestBody @Valid ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }


    // GET /api/applications - получение списка кандидатов
    @GetMapping()
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }


    // PUT /api/applications/{id} - обновление кандидата
    @PutMapping(ID)
    public Application updateApplication(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }


    // DELETE /api/applications/{id} - удаление кандидата
    @DeleteMapping(ID)
    public void deleteApplication(@PathVariable("id") final Long id) {
        applicationService.deleteApplicationById(id);
    }


    //----------------------HR----------------------//

    // GET /api/applications/hr/id - получение списка заявок по id юзера
    @GetMapping(HR + ID)
    public List<ApplicationForListDto> getAllApplicationsList(@PathVariable("id") final Long id) {
        return applicationService.getListOfCandidateApplication(id);
    }

}
