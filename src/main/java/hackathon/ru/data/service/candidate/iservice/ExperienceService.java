package hackathon.ru.data.service.candidate.iservice;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.candidate.Experience;

import java.util.List;

public interface ExperienceService {
    Experience getExperienceById(Long id);
    List<Experience> getAllExperiences();
    Experience createExperience(EducationDto educationDto);
    Experience updateExperience(Long id, EducationDto educationDto);
    void deleteExperienceById(Long id);
}
