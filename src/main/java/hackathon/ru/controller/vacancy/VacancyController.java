package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForCandidateDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForHrDto;
import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyForListDto;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.service.vacancy.iService.VacancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Vacancy Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyController.VACANCY_CONTROLLER_PATH)
public class VacancyController {
    public static final String VACANCY_CONTROLLER_PATH = "/vacancies";
    private static final String HR = "/hr";
    public static final String ID = "/{id}";

    private final VacancyService vacancyService;

    @Operation(summary = "Create new Vacancy")
    @ApiResponse(responseCode = "201", description = "User was successfully created")
    @ResponseStatus(CREATED)
    @PostMapping()
    public Vacancy createVacancy(@RequestBody @Valid VacancyDto vacancyDto) {
        return vacancyService.createVacancy(vacancyDto);
    }


    @Operation(summary = "Get Vacancies List for Candidate")
    @ApiResponse(responseCode = "200", description = "Vacancies was successfully found")
    @GetMapping()
    public List<VacancyForListDto> getVacanciesListForCandidate() {
        return vacancyService.getVacanciesListForCandidates();
    }

    @Operation(summary = "Get Vacancies List for Hr")
    @ApiResponse(responseCode = "200", description = "Vacancies was successfully found")
    @GetMapping(HR)
    public List<VacancyForListDto> getVacanciesListForHr() {
        return vacancyService.getVacanciesListForHr();
    }

    @Operation(summary = "Get Vacancy by ID for Candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vacancy with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Vacancy with that id does not exist")
    })
    @GetMapping(ID)
    public VacancyCardForCandidateDto getVacancyForCandidateById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForCandidateById(id);
    }

    @Operation(summary = "Get Vacancy by ID for Hr")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vacancy with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "Vacancy with that id does not exist")
    })
    @GetMapping(HR + ID)
    public VacancyCardForHrDto getVacancyForHrById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForHrById(id);
    }
}

