package hackathon.ru.data.service.vacancy.iService;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.vacancy.RequiredExperience;

import java.util.List;

public interface RequiredExperienceService {
    RequiredExperience getRequiredExperienceById(Long id);
    List<RequiredExperience> getAllRequiredExperiences();
    RequiredExperience createRequiredExperience(EducationDto educationDto);
    RequiredExperience updateRequiredExperience(Long id, EducationDto educationDto);
    void deleteRequiredExperienceById(Long id);
}
