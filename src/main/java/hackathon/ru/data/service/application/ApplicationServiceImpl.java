package hackathon.ru.data.service.application;


import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.repository.ApplicationRepository;
import hackathon.ru.data.service.application.iService.ApplicationService;
import hackathon.ru.data.service.application.iService.ApplicationStatusService;
import hackathon.ru.data.service.vacancy.iService.VacancyService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final VacancyService vacancyService;
    private final CandidateService candidateService;
    private final ApplicationStatusService applicationStatusService;

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
        Vacancy vacancy = vacancyService.getVacancyById(applicationDto.getVacancyId());
        Candidate candidate = candidateService.getCandidateById(applicationDto.getCandidateId());
        ApplicationStatus applicationStatus = applicationStatusService
                .getApplicationStatusById(applicationDto.getApplicationStatusId());

        Application application = Application.builder()
                .comment(applicationDto.getComment())
                .applicationStatus(applicationStatus)
                .candidate(candidate)
                .vacancy(vacancy)
                .build();

        return applicationRepository.save(application);
    }


    @Override
    public Application updateApplication(Long id, ApplicationDto applicationDto) {
        Application applicationToUpdate = getApplicationById(id);

        Vacancy vacancy = vacancyService.getVacancyById(applicationDto.getVacancyId());
        Candidate candidate = candidateService.getCandidateById(applicationDto.getCandidateId());
        ApplicationStatus applicationStatus = applicationStatusService
                .getApplicationStatusById(applicationDto.getApplicationStatusId());

        applicationToUpdate.setCandidate(candidate);
        applicationToUpdate.setVacancy(vacancy);
        applicationToUpdate.setApplicationStatus(applicationStatus);
        applicationToUpdate.setComment(applicationDto.getComment());

        return applicationToUpdate;
    }

    @Override
    public void deleteApplicationById(Long id) {
        applicationRepository.deleteById(id);
    }
}

