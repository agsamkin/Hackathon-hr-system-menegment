package hackathon.ru.data.service.application.iService;


import hackathon.ru.data.dto.application.ApplicationStatusDto;
import hackathon.ru.data.model.application.ApplicationStatus;

import java.util.List;

public interface ApplicationStatusService {
    ApplicationStatus getApplicationStatusById(Long id);
    List<ApplicationStatus> getAllApplicationStatuses();
    ApplicationStatus createApplicationStatus(ApplicationStatusDto applicationStatusDto);
    ApplicationStatus updateApplicationStatus(Long id, ApplicationStatusDto applicationStatusDto);
    void deleteApplicationStatusById(Long id);
}
