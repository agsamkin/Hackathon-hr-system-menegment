package hackathon.ru.controller.application;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationForCardDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationForListDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationCreatedDto;
import hackathon.ru.data.dto.application.inputDto.CommentDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ApplicationVacancyCandidateDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.service.application.iService.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public static final String APPLICATION = "/application";
    public static final String COMMENT = "/comment";

    private final ApplicationService applicationService;



    // GET /api/applications/{id} - получение по идентификатору

    @Operation(summary = "Get Application by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Application with that id does not exist")
    })
    @GetMapping(ID)
    public Application getApplicationById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationById(id);
    }

    @Operation(summary = "Create new Application")
    @ApiResponse(responseCode = "201", description = "Application was successfully created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public ApplicationCreatedDto createApplication(
            @RequestBody @Valid ApplicationVacancyCandidateDto applicationVacancyCandidateDto) {
        return applicationService.createApplication(applicationVacancyCandidateDto);
    }

    @Operation(summary = "Get all Applications")
    @ApiResponse(responseCode = "200", description = "Applications was successfully found")
    @GetMapping()
    public List<ApplicationForListDto> getAllApplications() {
        return applicationService.getAllApplications();
    }


    @Operation(summary = "Update Application by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "Application with that id does not exist")
    })
    @PutMapping(ID)
    public Application updateApplication(@PathVariable("id") final Long id,
                                         @RequestBody @Valid final ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }

    @Operation(summary = "Update Application's comment by application id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application's comment with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "Application with that id does not exist")
    })
    @PutMapping(ID + COMMENT)
    public CommentDto updateApplicationComment(@PathVariable("id") final Long id,
                                           @RequestBody CommentDto commentDto) {
        return applicationService.updateApplicationComment(id, commentDto);
    }

    @Operation(summary = "Delete Application by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application with that id was successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Application with that id does not exist")
    })
    @DeleteMapping(ID)
    public void deleteApplication(@PathVariable("id") final Long id) {
        applicationService.deleteApplicationById(id);
    }


    //----------------------HR----------------------//
    // GET /api/applications/hr/application/{id} получение всех заявок кондидата
    @Operation(summary = "Get all Applications of Candidate by candidate Id")
    @ApiResponse(responseCode = "200", description = "Applications was successfully found")
    @GetMapping(HR + ID)
    public List<ApplicationForListDto> getListOfCandidateApplicationsByCandidateId(@PathVariable("id") final Long id) {
        return applicationService.getListOfCandidateApplicationsByCandidateId(id);
    }


    // GET /api/applications/hr/application/{id} - получение кандидата по id заявке
    @Operation(summary = "Get  Application for Card by Id")
    @ApiResponse(responseCode = "200", description = "Application was successfully found")
    @GetMapping(HR + APPLICATION + ID)
    public ApplicationForCardDto getApplicationCardById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationForCardDto(id);
    }

}
