package hackathon.ru.service.iService;

import hackathon.ru.dto.candidate.EducationDto;
import hackathon.ru.model.vacancy.RequiredExperience;

import java.util.List;

public interface RequiredExperienceService {
    RequiredExperience getRequiredExperienceById(Long id);
    List<RequiredExperience> getAllRequiredExperiences();
    RequiredExperience createRequiredExperience(EducationDto educationDto);
    RequiredExperience updateRequiredExperience(Long id, EducationDto educationDto);
    void deleteRequiredExperienceById(Long id);
}
