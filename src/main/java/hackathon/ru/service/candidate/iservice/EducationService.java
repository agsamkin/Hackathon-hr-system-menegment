package hackathon.ru.service.candidate.iservice;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.candidate.Education;

import java.util.List;

public interface EducationService {
    Education getEducationById(Long id);
    List<Education> getAllEducations();
    Education createEducation(EducationDto educationDto);
    Education updateEducation(Long id, EducationDto educationDto);
    void deleteEducationById(Long id);
}
