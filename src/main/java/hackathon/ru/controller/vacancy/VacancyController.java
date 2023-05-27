package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.customDto.VacancyCardForCandidateDto;
import hackathon.ru.data.dto.vacancy.customDto.VacancyCardForHrDto;
import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.customDto.VacancyForListDto;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.service.vacancy.iService.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyController.VACANCY_CONTROLLER_PATH)
public class VacancyController {
    public static final String VACANCY_CONTROLLER_PATH = "/vacancies";
    private static final String HR = "/hr";
    public static final String ID = "/{id}";

    private final VacancyService vacancyService;


    @PostMapping()
    public Vacancy createVacancy(@RequestBody @Valid VacancyDto vacancyDto) {
        return vacancyService.createVacancy(vacancyDto);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<VacancyForListDto> getVacanciesListForCandidate() {
        return vacancyService.getVacanciesListForCandidates();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(HR)
    public List<VacancyForListDto> getVacanciesListForHr() {
        return vacancyService.getVacanciesListForHr();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(ID)
    public VacancyCardForCandidateDto getVacancyForCandidateById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForCandidateById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(HR + ID)
    public VacancyCardForHrDto getVacancyForHrById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForHrById(id);
    }
}

