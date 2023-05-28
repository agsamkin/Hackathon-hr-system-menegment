package hackathon.ru.controller.application;

import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.service.application.iService.ApplicationStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + ApplicationStatusController.APPLICATION_STATUS_CONTROLLER_PATH)
public class ApplicationStatusController {
    public static final String APPLICATION_STATUS_CONTROLLER_PATH = "/application-statuses";

    private static final String ID = "/{id}";

    private final ApplicationStatusService applicationStatusService;


    @GetMapping(ID)
    public ApplicationStatus getApplicationById(@PathVariable("id") final Long id) {
        return applicationStatusService.getApplicationStatusById(id);
    }


    @GetMapping()
    public List<ApplicationStatus> getAllApplications() {
        return applicationStatusService.getAllApplicationStatuses();
    }


}
