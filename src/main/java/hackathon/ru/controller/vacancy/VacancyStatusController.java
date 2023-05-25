package hackathon.ru.controller.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyStatusDto;
import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.data.service.vacancy.iService.VacancyStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyStatusController.VACANCY_STATUS_CONTROLLER_PATH)
public class VacancyStatusController {
    public static final String VACANCY_STATUS_CONTROLLER_PATH = "/vacancyStatuses";
    public static final String ID = "/{id}";

    private final VacancyStatusService vacancyStatusService;


    @GetMapping(ID)
    public VacancyStatus getWorkFormatById(@PathVariable("id") final long id) {
        return vacancyStatusService.getVacancyStatusById(id);
    }

    @GetMapping()
    public List<VacancyStatus> getAllVacancyStatuses() {
        return vacancyStatusService.getAllVacancyStatuses();
    }


    @PostMapping()
    public VacancyStatus createVacancyStatuses(@RequestBody @Valid VacancyStatusDto vacancyStatusDto) {
        return vacancyStatusService.createVacancyStatus(vacancyStatusDto);
    }

}
