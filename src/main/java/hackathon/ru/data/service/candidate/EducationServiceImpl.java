package hackathon.ru.data.service.candidate;

import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.repository.EducationRepository;
import hackathon.ru.data.service.candidate.iservice.DegreeService;
import hackathon.ru.data.service.candidate.iservice.EducationService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

        Education education = Education.builder()
                .university(educationDto.getUniversity())
                .graduationYear(educationDto.getGraduationYear())
                .specialization(educationDto.getSpecialization())
                .degree(degree)
                .candidate(educationDto.getCandidateIds())
                .build();
        return educationRepository.save(education);

    }

    @Override
    public Education updateEducation(Long id, EducationDto educationDto) {

        Degree degree = degreeService.getDegreeById(educationDto.getDegreeIds());

        Education educationToUpdate = getEducationById(id);

        educationToUpdate.setUniversity(educationDto.getUniversity());
        educationToUpdate.setGraduationYear(educationDto.getGraduationYear());
        educationToUpdate.setSpecialization(educationDto.getSpecialization());
        educationToUpdate.setDegree(degree);
        educationToUpdate.setCandidate(educationDto.getCandidateIds());

        return educationRepository.save(educationToUpdate);
    }

    @Override
    public void deleteEducationById(Long id) {
        educationRepository.deleteById(id);
    }
}
