package hackathon.ru.data.service.vacancy.iService;


import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.model.vacancy.Vacancy;

import java.util.List;

public interface VacancyStatusService {
    Vacancy getVacancyStatusById(Long id);

    List<Vacancy> getAllVacancyStatuses();

    Vacancy createVacancyStatus(VacancyDto vacancyDto);

    Vacancy updateVacancyStatus(Long id, VacancyDto vacancyDto);

    void deleteVacancyStatusById(Long id);
}
