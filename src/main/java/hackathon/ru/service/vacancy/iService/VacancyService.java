package hackathon.ru.service.vacancy.iService;


import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForCandidateDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyCardForHrDto;
import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.outputDto.VacancyForListDto;
import hackathon.ru.data.model.vacancy.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy getVacancyById(Long id);

    List<Vacancy> getAllVacancies();

    Vacancy createVacancy(VacancyDto vacancyDto);

    Vacancy updateVacancy(Long id, VacancyDto vacancyDto);

    void deleteVacancyById(Long id);

    List<VacancyForListDto> getVacanciesListForCandidates();

    List<VacancyForListDto> getVacanciesListForHr();

    VacancyCardForCandidateDto getVacancyCardForCandidateById(Long id);

    VacancyCardForHrDto getVacancyCardForHrById(Long id);
}
