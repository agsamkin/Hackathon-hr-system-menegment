package hackathon.ru.service.iService;

import hackathon.ru.dto.CityDto;
import hackathon.ru.model.City;
import hackathon.ru.model.candidate.Degree;

import java.util.List;

public interface DegreeService {
    Degree getDegreeById(Long id);
    List<Degree> getAllDegrees();
    Degree createDegree(CityDto cityDto);
    City updateCity(Long id, CityDto cityDto);
    void deleteCityById(Long id);
}
