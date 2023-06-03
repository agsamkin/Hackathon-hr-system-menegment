package hackathon.ru.service.application;


import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.repository.ApplicationStatusRepository;
import hackathon.ru.service.application.iService.ApplicationStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

    private final ApplicationStatusRepository applicationStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public ApplicationStatus getApplicationStatusById(Long id) {
        return applicationStatusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Application status with this id is not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApplicationStatus> getAllApplicationsStatuses() {
        return new ArrayList<>(applicationStatusRepository.findAll());
    }

}
