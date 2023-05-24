package hackaton.ru.service.iService;

import hackaton.ru.dto.CityDto;
import hackaton.ru.model.City;
import hackaton.ru.model.candidate.Degree;

import java.util.List;

public interface DegreeService {
    Degree getDegreeById(Long id);
    List<Degree> getAllDegrees();
    Degree createDegree(CityDto cityDto);
    City updateCity(Long id, CityDto cityDto);
    void deleteCityById(Long id);
}
