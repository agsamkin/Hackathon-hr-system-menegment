package hackaton.ru.service.iService;



import hackaton.ru.dto.application.ApplicationDto;
import hackaton.ru.model.application.Application;

import java.util.List;

public interface ApplicationService {
    Application getApplicationById(Long id);
    List<Application> getAllApplications();
    Application createApplication(ApplicationDto applicationDto);
    Application updateApplication(Long id, ApplicationDto applicationDto);
    void deleteApplicationById(Long id);
}
