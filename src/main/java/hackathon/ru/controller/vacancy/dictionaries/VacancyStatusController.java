package hackathon.ru.controller.vacancy.dictionaries;

import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.service.vacancy.iService.VacancyStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Vacancy Status Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyStatusController.VACANCY_STATUS_CONTROLLER_PATH)
public class VacancyStatusController {
    public static final String VACANCY_STATUS_CONTROLLER_PATH = "/vacancy-statuses";
    public static final String ID = "/{id}";

    private final VacancyStatusService vacancyStatusService;

    @Operation(summary = "Get Vacancy Status by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vacancy Status with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Vacancy Status with that id does not exist")
    })
    @GetMapping(ID)
    public VacancyStatus getVacancyStatusById(@PathVariable("id") final long id) {
        return vacancyStatusService.getVacancyStatusById(id);
    }

    @Operation(summary = "Get All Vacancy Statuses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vacancy Statuses was successfully found"),
    })
    @GetMapping()
    public List<VacancyStatus> getAllVacancyStatuses() {
        return vacancyStatusService.getAllVacancyStatuses();
    }

}

