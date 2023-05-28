package hackathon.ru.controller;


import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.model.City;
import hackathon.ru.service.cityService.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + CityController.CITIES_CONTROLLER_PATH)
public class CityController {
    public static final String CITIES_CONTROLLER_PATH = "/cities";

    public static final String ID = "/{id}";

    private final CityService cityService;

    @GetMapping(ID)
    public City getVacanciesById(@PathVariable("id") final long id) {
        return cityService.getCityById(id);
    }

    @GetMapping()
    public List<City> getAllVacancies() {
        return cityService.getAllCities();
    }

    @PostMapping()
    public City createVacancy(@RequestBody @Valid CityDto cityDto) {
        return cityService.createCity(cityDto);
    }

}
