package hackathon.ru.service.iService;

import hackathon.ru.dto.vacancy.VacancyDto;
import hackathon.ru.model.vacancy.WorkFormat;

import java.util.List;

public interface WorkFormatService {
    WorkFormat getWorkFormatById(Long id);

    List<WorkFormat> getAllWorkFormats();

    WorkFormat createWorkFormat(VacancyDto VacancyDto);

    WorkFormat updateWorkFormat(Long id, VacancyDto vacancyDto);

    void deleteWorkFormatById(Long id);
}
