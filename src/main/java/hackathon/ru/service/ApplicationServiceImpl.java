package hackathon.ru.service;


import hackathon.ru.dto.application.ApplicationDto;
import hackathon.ru.model.application.Application;
import hackathon.ru.service.iService.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {


    @Override
    public Application getApplicationById(Long id) {
        return null;
    }

    @Override
    public List<Application> getAllApplications() {
        return null;
    }

    @Override
    public Application createApplication(ApplicationDto applicationDto) {
        return null;
    }

    @Override
    public Application updateApplication(Long id, ApplicationDto applicationDto) {
        return null;
    }

    @Override
    public void deleteApplicationById(Long id) {

    }
}
