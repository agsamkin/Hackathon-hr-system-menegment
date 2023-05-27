package hackathon.ru.service.vacancy;

import hackathon.ru.data.dto.vacancy.RequiredExperienceDto;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.repository.RequiredExperienceRepository;
import hackathon.ru.service.vacancy.iService.RequiredExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class RequiredExperienceServiceImpl implements RequiredExperienceService {

    private final RequiredExperienceRepository requiredExperienceRepository;

    @Override
    public RequiredExperience getRequiredExperienceById(Long id) {
        return requiredExperienceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("required experience with that id is not found"));
    }

    @Override
    public List<RequiredExperience> getAllRequiredExperiences() {
        return requiredExperienceRepository.findAll();
    }

    @Override
    public RequiredExperience createRequiredExperience(RequiredExperienceDto requiredExperienceDto) {
        RequiredExperience requiredExperience = RequiredExperience.builder()
                .name(requiredExperienceDto.getName())
                .build();
        return requiredExperienceRepository.save(requiredExperience);
    }

    @Override
    public RequiredExperience updateRequiredExperience(Long id, RequiredExperienceDto requiredExperienceDto) {
        return null;
    }


    @Override
    public void deleteRequiredExperienceById(Long id) {

    }
}
