package hackathon.ru.data.service.candidate.iservice;

import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.dto.candidate.DegreeDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.candidate.Degree;

import java.util.List;

public interface DegreeService {
    Degree getDegreeById(Long id);
    List<Degree> getAllDegrees();
    Degree createDegree(DegreeDto degreeDto);
    Degree updateDegree(Long id, DegreeDto degreeDto);
    void deleteDegreeById(Long id);
}
