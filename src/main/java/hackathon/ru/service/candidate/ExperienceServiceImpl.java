package hackathon.ru.service.candidate;

import hackathon.ru.data.dto.candidate.ExperienceDto;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.service.candidate.iservice.CandidateService;
import hackathon.ru.service.candidate.iservice.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;
    private CandidateService candidateService;
    @Override
    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Experience with this id is not found"));
    }

    @Override
    public List<Experience> getAllExperiences() {
        return new ArrayList<>(experienceRepository.findAll());
    }

    @Override
    public Experience createExperience(ExperienceDto experienceDto) {

        Candidate candidate = candidateService.getCandidateById(experienceDto.getCandidateId());

        Experience experience = Experience.builder()
                .companyName(experienceDto.getCompanyName())
                .positionName(experienceDto.getPositionName())
                .startDate(experienceDto.getStartDate())
                .endDate(experienceDto.getEndDate())
                .description(experienceDto.getDescription())
                .candidate(candidate)
                .build();

        return experienceRepository.save(experience);
    }

    @Override
    public Experience updateExperience(Long id, ExperienceDto experienceDto) {
        Experience experienceToUpdate = getExperienceById(id);
        Candidate candidate = candidateService.getCandidateById(experienceDto.getCandidateId());

        experienceToUpdate.setCompanyName(experienceDto.getCompanyName());
        experienceToUpdate.setPositionName(experienceDto.getPositionName());
        experienceToUpdate.setStartDate(experienceDto.getStartDate());
        experienceToUpdate.setEndDate(experienceDto.getEndDate());
        experienceToUpdate.setDescription(experienceDto.getDescription());
        experienceToUpdate.setCandidate(candidate);

        return experienceRepository.save(experienceToUpdate);
    }

    @Override
    public void deleteExperienceById(Long id) {
        experienceRepository.deleteById(id);
    }
}
