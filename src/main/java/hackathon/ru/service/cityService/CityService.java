package hackathon.ru.service.cityService;


import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.model.City;

import java.util.List;

public interface CityService {
    City getCityById(Long id);
    List<City> getAllCities();
    City createCity(CityDto cityDto);
    City updateCity(Long id, CityDto cityDto);
    void deleteCityById(Long id);
}
