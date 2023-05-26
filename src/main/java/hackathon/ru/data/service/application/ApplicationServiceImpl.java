package hackathon.ru.data.service.application;


import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.repository.ApplicationRepository;
import hackathon.ru.data.repository.ApplicationStatusRepository;
import hackathon.ru.data.service.application.iService.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Application with that id is not found"));
    }

    @Override
    public List<Application> getAllApplications() {
        return new ArrayList<>(applicationRepository.findAll());
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
        applicationRepository.deleteById(id);
    }
}
