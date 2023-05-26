package hackathon.ru.data.service.candidate.iservice;

import hackathon.ru.data.dto.candidate.ExperienceDto;
import hackathon.ru.data.model.candidate.Experience;

import java.util.List;

public interface ExperienceService {
    Experience getExperienceById(Long id);
    List<Experience> getAllExperiences();
    Experience createExperience(ExperienceDto experienceDto);
    Experience updateExperience(Long id, ExperienceDto experienceDto);
    void deleteExperienceById(Long id);
}
