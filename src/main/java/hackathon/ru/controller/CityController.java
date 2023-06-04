package hackathon.ru.controller;


import hackathon.ru.data.dto.CityDto;
import hackathon.ru.data.model.City;
import hackathon.ru.service.cityService.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "City Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + CityController.CITIES_CONTROLLER_PATH)
public class CityController {
    public static final String CITIES_CONTROLLER_PATH = "/cities";

    public static final String ID = "/{id}";

    private final CityService cityService;

    @Operation(summary = "Get City by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "City with that id does not exist")
    })
    @GetMapping(ID)
    public City getCityById(@PathVariable("id") final long id) {
        return cityService.getCityById(id);
    }

    @Operation(summary = "Get all Cities")
    @ApiResponse(responseCode = "200", description = "Cities was successfully found")
    @GetMapping()
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @Operation(summary = "create new City")
    @ApiResponse(responseCode = "200", description = "City was successfully creates")
    @PostMapping()
    @ResponseStatus(CREATED)
    public City createCity(@RequestBody @Valid CityDto cityDto) {
        return cityService.createCity(cityDto);
    }

}
