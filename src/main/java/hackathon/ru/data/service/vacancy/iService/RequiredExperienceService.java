package hackathon.ru.data.service.vacancy.iService;

import hackathon.ru.data.dto.vacancy.RequiredExperienceDto;
import hackathon.ru.data.model.vacancy.RequiredExperience;

import java.util.List;

public interface RequiredExperienceService {
    RequiredExperience getRequiredExperienceById(Long id);
    List<RequiredExperience> getAllRequiredExperiences();
    RequiredExperience createRequiredExperience(RequiredExperienceDto requiredExperienceDto);
    RequiredExperience updateRequiredExperience(Long id, RequiredExperienceDto requiredExperienceDto);
    void deleteRequiredExperienceById(Long id);
}
