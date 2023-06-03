package hackathon.ru.service.candidate;

import hackathon.ru.data.dto.candidate.DegreeDto;
import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.data.repository.DegreeRepository;
import hackathon.ru.service.candidate.iservice.DegreeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class DegreeServiceImpl implements DegreeService {

    private DegreeRepository degreeRepository;

    @Override
    public Degree getDegreeById(Long id) {
        return degreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Degree with this id is not found"));
    }

    @Override
    public List<Degree> getAllDegrees() {
        return new ArrayList<>(degreeRepository.findAll());
    }
}
