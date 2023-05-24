package hackaton.ru.service.iService;


import hackaton.ru.dto.application.ApplicationStatusDto;
import hackaton.ru.model.application.ApplicationStatus;

import java.util.List;

public interface ApplicationStatusService {
    ApplicationStatus getApplicationStatusById(Long id);
    List<ApplicationStatus> getAllApplicationStatuses();
    ApplicationStatus createApplicationStatus(ApplicationStatusDto applicationStatusDto);
    ApplicationStatusDto updateApplicationStatus(Long id, ApplicationStatusDto applicationStatusDto);
    void deleteApplicationStatusById(Long id);
}
