package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForCandidateDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForHrDto;
import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyForListDto;
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

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @PostMapping()
    public Vacancy createVacancy(@RequestBody @Valid VacancyDto vacancyDto) {
        return vacancyService.createVacancy(vacancyDto);
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping()
    public List<VacancyForListDto> getVacanciesListForCandidate() {
        return vacancyService.getVacanciesListForCandidates();
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping(HR)
    public List<VacancyForListDto> getVacanciesListForHr() {
        return vacancyService.getVacanciesListForHr();
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping(ID)
    public VacancyCardForCandidateDto getVacancyForCandidateById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForCandidateById(id);
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping(HR + ID)
    public VacancyCardForHrDto getVacancyForHrById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyCardForHrById(id);
    }
}

