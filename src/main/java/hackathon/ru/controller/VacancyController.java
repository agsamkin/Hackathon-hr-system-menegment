package hackathon.ru.controller;

import hackathon.ru.dto.vacancy.VacancyDto;
import hackathon.ru.model.vacancy.Vacancy;
import hackathon.ru.service.iService.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyController.VACANCIES_CONTROLLER_PATH)
public class VacancyController {
    public static final String VACANCIES_CONTROLLER_PATH = "/vacancies";

    public static final String ID = "/{id}";

    private final VacancyService vacancyService;

    @GetMapping(ID)
    public Vacancy getVacanciesById(@PathVariable("id") final long id) {
        return vacancyService.getVacancyById(id);
    }

    @GetMapping()
    public List<Vacancy> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @PostMapping()
    public Vacancy createVacancy(@RequestBody @Valid VacancyDto vacancyDto) {
        return vacancyService.createVacancy(vacancyDto);
    }




}
