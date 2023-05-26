package hackathon.ru.data.service.candidate;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.repository.EducationRepository;
import hackathon.ru.data.service.candidate.iservice.DegreeService;
import hackathon.ru.data.service.candidate.iservice.EducationService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;
    private CandidateService candidateService;
    private DegreeService degreeService;

    @Override
    public Education getEducationById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Education with this id is not found"));
    }

    @Override
    public List<Education> getAllEducations() {
        return new ArrayList<>(educationRepository.findAll());
    }

    @Override
    public Education createEducation(EducationDto educationDto) {
        Degree degree = degreeService.getDegreeById(educationDto.getDegreeIds());
        Candidate candidate = candidateService.getCandidateById(educationDto.getCandidateIds());

        Education education = Education.builder()
                .university(educationDto.getUniversity())
                .graduationYear(educationDto.getGraduationYear())
                .specialization(educationDto.getSpecialization())
                .degree(degree)
                .candidate(candidate)
                .build();
        return educationRepository.save(education);

    }

    @Override
    public Education updateEducation(Long id, EducationDto educationDto) {

        Degree degree = degreeService.getDegreeById(educationDto.getDegreeIds());
        Candidate candidate = candidateService.getCandidateById(educationDto.getCandidateIds());

        Education educationToUpdate = getEducationById(id);

        educationToUpdate.setUniversity(educationDto.getUniversity());
        educationToUpdate.setGraduationYear(educationDto.getGraduationYear());
        educationToUpdate.setSpecialization(educationDto.getSpecialization());
        educationToUpdate.setDegree(degree);
        educationToUpdate.setCandidate(candidate);

        return educationRepository.save(educationToUpdate);
    }

    @Override
    public void deleteEducationById(Long id) {
        educationRepository.deleteById(id);
    }
}
