package hackathon.ru.data.service.candidate.iservice;

import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.candidate.Degree;

import java.util.List;

public interface DegreeService {
    Degree getDegreeById(Long id);
    List<Degree> getAllDegrees();
    Degree createDegree(CityDto cityDto);
    City updateCity(Long id, CityDto cityDto);
    void deleteCityById(Long id);
}
