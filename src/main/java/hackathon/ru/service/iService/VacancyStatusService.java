package hackathon.ru.service.iService;


import hackathon.ru.dto.vacancy.VacancyDto;
import hackathon.ru.model.vacancy.Vacancy;

import java.util.List;

public interface VacancyStatusService {
    Vacancy getVacancyStatusById(Long id);

    List<Vacancy> getAllVacancyStatuses();

    Vacancy createVacancyStatus(VacancyDto vacancyDto);

    Vacancy updateVacancyStatus(Long id, VacancyDto vacancyDto);

    void deleteVacancyStatusById(Long id);
}
