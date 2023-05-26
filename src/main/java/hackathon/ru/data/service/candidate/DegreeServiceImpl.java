package hackathon.ru.data.service.candidate;

import hackathon.ru.data.dto.candidate.DegreeDto;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.data.repository.DegreeRepository;
import hackathon.ru.data.service.candidate.iservice.DegreeService;
import hackathon.ru.data.service.candidate.iservice.EducationService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DegreeServiceImpl implements DegreeService {

    private DegreeRepository degreeRepository;
    private EducationService educationService;

    @Override
    public Degree getDegreeById(Long id) {
        return degreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Degree with this id is not found"));
    }

    @Override
    public List<Degree> getAllDegrees() {
        return new ArrayList<>(degreeRepository.findAll());
    }

    @Override
    public Degree createDegree(DegreeDto degreeDto) {

        List<Long> educationsIds = degreeDto.getEducationsIds();
        List<Education> educations = new ArrayList<>();

        for(Long educationsId : educationsIds) {
            Education education = educationService.getEducationById(educationsId);
            educations.add(education);
        }

        Degree degree = Degree.builder()
                .name(degreeDto.getName())
                .educations(educations)
                .build();

        return degreeRepository.save(degree);
    }

    @Override
    public Degree updateDegree(Long id, DegreeDto degreeDto) {
        Degree degreeToUpdate = getDegreeById(id);
        List<Long> educationsIds = degreeDto.getEducationsIds();
        List<Education> educations = new ArrayList<>();

        for(Long educationsId : educationsIds) {
            Education education = educationService.getEducationById(educationsId);
            educations.add(education);
        }

        degreeToUpdate.setName(degreeDto.getName());
        degreeToUpdate.setEducations(educations);
        return degreeRepository.save(degreeToUpdate);
    }

    @Override
    public void deleteDegreeById(Long id) {
        degreeRepository.deleteById(id);
    }
}
