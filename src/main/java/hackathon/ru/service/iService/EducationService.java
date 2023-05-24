package hackathon.ru.service.iService;

import hackathon.ru.dto.candidate.EducationDto;
import hackathon.ru.model.candidate.Education;

import java.util.List;

public interface EducationService {
    Education getEducationById(Long id);
    List<Education> getAllEducations();
    Education createEducation(EducationDto educationDto);
    Education updateEducation(Long id, EducationDto educationDto);
    void deleteEducationById(Long id);
}
