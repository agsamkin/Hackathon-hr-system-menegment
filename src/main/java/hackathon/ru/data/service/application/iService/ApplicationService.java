package hackathon.ru.data.service.application.iService;



import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.model.application.Application;

import java.util.List;

public interface ApplicationService {
    Application getApplicationById(Long id);
    List<Application> getAllApplications();
    Application createApplication(ApplicationDto applicationDto);
    Application updateApplication(Long id, ApplicationDto applicationDto);
    void deleteApplicationById(Long id);
    List<ApplicationForListDto> getListOfCandidateApplication(Long id);
}
