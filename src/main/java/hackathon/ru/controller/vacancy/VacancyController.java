package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.VacancyForListDto;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.service.vacancy.iService.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyController.VACANCY_CONTROLLER_PATH)
public class VacancyController {
    public static final String VACANCY_CONTROLLER_PATH = "/vacancies";

    public static final String ID = "/{id}";

    private final VacancyService vacancyService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(ID)
    public Vacancy getVacanciesById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyById(id);
    }

//    @GetMapping()
//    public List<Vacancy> getAllVacancies() {
//        return vacancyService.getAllVacancies();
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<VacancyForListDto> getAllVacanciesForList() {
        return vacancyService.getVacancyList();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public Vacancy createVacancy(@RequestBody @Valid VacancyDto vacancyDto) {
        return vacancyService.createVacancy(vacancyDto);
    }

}
