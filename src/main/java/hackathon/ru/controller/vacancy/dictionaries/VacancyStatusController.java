package hackathon.ru.controller.vacancy.dictionaries;

import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.data.service.vacancy.iService.VacancyStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + VacancyStatusController.VACANCY_STATUS_CONTROLLER_PATH)
public class VacancyStatusController {
    public static final String VACANCY_STATUS_CONTROLLER_PATH = "/vacancy-statuses";
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

}

