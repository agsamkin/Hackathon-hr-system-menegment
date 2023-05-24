package hackathon.ru.service.iService;


import hackathon.ru.dto.vacancy.VacancyDto;
import hackathon.ru.model.vacancy.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy getVacancyById(Long id);

    List<Vacancy> getAllVacancies();

    Vacancy createVacancy(VacancyDto VacancyDto);

    Vacancy updateVacancy(Long id, VacancyDto vacancyDto);

    void deleteVacancyById(Long id);
}
