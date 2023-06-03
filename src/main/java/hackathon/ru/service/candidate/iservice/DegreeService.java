package hackathon.ru.service.candidate.iservice;

import hackathon.ru.data.model.candidate.Degree;

import java.util.List;

public interface DegreeService {
    Degree getDegreeById(Long id);
    List<Degree> getAllDegrees();

}
