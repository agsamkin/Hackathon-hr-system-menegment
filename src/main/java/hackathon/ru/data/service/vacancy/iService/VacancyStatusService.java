package hackathon.ru.data.service.vacancy.iService;


import hackathon.ru.data.dto.vacancy.VacancyStatusDto;
import hackathon.ru.data.model.vacancy.VacancyStatus;

import java.util.List;

public interface VacancyStatusService {
    VacancyStatus getVacancyStatusById(Long id);

    List<VacancyStatus> getAllVacancyStatuses();

    VacancyStatus createVacancyStatus(VacancyStatusDto vacancyStatusDto);

    VacancyStatus updateVacancyStatus(Long id, VacancyStatusDto vacancyStatusDto);

    void deleteVacancyStatusById(Long id);
}
