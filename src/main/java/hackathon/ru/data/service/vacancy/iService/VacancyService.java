package hackathon.ru.data.service.vacancy.iService;


import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.VacancyForListDto;
import hackathon.ru.data.model.vacancy.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy getVacancyById(Long id);

    List<Vacancy> getAllVacancies();

    List<VacancyForListDto> getVacancyList();

    Vacancy createVacancy(VacancyDto VacancyDto);

    Vacancy updateVacancy(Long id, VacancyDto vacancyDto);

    void deleteVacancyById(Long id);
}
