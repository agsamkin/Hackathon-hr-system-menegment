package hackathon.ru.service.application;


import hackathon.ru.data.dto.application.ApplicationStatusDto;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.repository.ApplicationStatusRepository;
import hackathon.ru.service.application.iService.ApplicationStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApplicationStatusServiceImpl implements ApplicationStatusService {


    private final ApplicationStatusRepository applicationStatusRepository;


    @Override
    public ApplicationStatus getApplicationStatusById(Long id) {
        return applicationStatusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Application status with this id is not found"));
    }

    @Override
    public List<ApplicationStatus> getAllApplicationStatuses() {
        return new ArrayList<>(applicationStatusRepository.findAll());
    }

    @Override
    public ApplicationStatus createApplicationStatus(ApplicationStatusDto applicationStatusDto) {
        return null;
    }

    @Override
    public ApplicationStatus updateApplicationStatus(Long id, ApplicationStatusDto applicationStatusDto) {
        return null;
    }

    @Override
    public void deleteApplicationStatusById(Long id) {
        applicationStatusRepository.deleteById(id);
    }
}
