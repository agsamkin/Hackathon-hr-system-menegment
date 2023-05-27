package hackathon.ru.controller;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.ApplicationForListDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.service.application.iService.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Get application by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application was found"),
            @ApiResponse(responseCode = "404", description = "Application with this ID does not exist")
    })
    @GetMapping(ID)
    public Application getApplicationById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationById(id);
    }


    // POST /api/applications - создание нового кандидата
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Create new application")
    @ApiResponse(responseCode = "201", description = "Application created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Application createApplication(
            @Parameter(schema = @Schema(implementation = ApplicationDto.class))
            @RequestBody @Valid ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }


    // GET /api/applications - получение списка кандидатов
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Get all applications")
    @ApiResponse(responseCode = "200", description = "List of applications was successfully found")
    @GetMapping()
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }


    // PUT /api/applications/{id} - обновление кандидата
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Update application by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application updated"),
            @ApiResponse(responseCode = "404", description = "Application with this ID not found")
    })
    @PutMapping(ID)
    public Application updateApplication(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }


    // DELETE /api/applications/{id} - удаление кандидата
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Delete candidate by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application deleted"),
            @ApiResponse(responseCode = "404", description = "Application with this ID is not found")
    })
    @DeleteMapping(ID)
    public void deleteApplication(@PathVariable("id") final Long id) {
        applicationService.deleteApplicationById(id);
    }


    //----------------------HR----------------------//

    // GET /api/applications/hr/id - получение списка заявок по id юзера
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Get all applications")
    @ApiResponse(responseCode = "200", description = "List of applications was successfully found")
    @GetMapping(HR + ID)
    public List<ApplicationForListDto> getAllApplicationsList(@PathVariable("id") final Long id) {
        return applicationService.getListOfCandidateApplication(id);
    }

}
