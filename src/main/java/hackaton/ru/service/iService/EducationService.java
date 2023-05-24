package hackaton.ru.service.iService;

import hackaton.ru.dto.CityDto;
import hackaton.ru.dto.candidate.EducationDto;
import hackaton.ru.model.City;
import hackaton.ru.model.candidate.Degree;
import hackaton.ru.model.candidate.Education;

import java.util.List;

public interface EducationService {
    Education getEducationById(Long id);
    List<Education> getAllEducations();
    Education createEducation(EducationDto educationDto);
    Education updateEducation(Long id, EducationDto educationDto);
    void deleteEducationById(Long id);
}
