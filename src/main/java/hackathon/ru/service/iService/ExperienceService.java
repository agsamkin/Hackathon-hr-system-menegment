package hackathon.ru.service.iService;

import hackathon.ru.dto.candidate.EducationDto;
import hackathon.ru.model.candidate.Experience;

import java.util.List;

public interface ExperienceService {
    Experience getExperienceById(Long id);
    List<Experience> getAllExperiences();
    Experience createExperience(EducationDto educationDto);
    Experience updateExperience(Long id, EducationDto educationDto);
    void deleteExperienceById(Long id);
}
