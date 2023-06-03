package hackathon.ru.service.application.iService;


import hackathon.ru.data.model.application.ApplicationStatus;

import java.util.List;

public interface ApplicationStatusService {
    ApplicationStatus getApplicationStatusById(Long id);
    List<ApplicationStatus> getAllApplicationsStatuses();
}
