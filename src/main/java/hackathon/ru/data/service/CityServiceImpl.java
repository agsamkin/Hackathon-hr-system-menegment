package hackathon.ru.data.service;


import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("City with this id is not found"));
    }

    @Override
    public List<City> getAllCities() {
        return new ArrayList<>(cityRepository.findAll());
    }

    @Override
    public City createCity(CityDto cityDto) {
        City city = City.builder()
                .name(cityDto.getName())
                .build();
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, CityDto cityDto) {
        City city = getCityById(id);
        city.setName(cityDto.getName());
        return cityRepository.save(city);
    }

    @Override
    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }
}
