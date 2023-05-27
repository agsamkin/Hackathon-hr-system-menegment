package hackathon.ru.data.service.application;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.ApplicationForListDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.repository.ApplicationRepository;
import hackathon.ru.data.service.application.iService.ApplicationService;
import hackathon.ru.data.service.application.iService.ApplicationStatusService;
import hackathon.ru.data.service.vacancy.iService.VacancyService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<ApplicationForListDto> getListOfCandidateApplication(Long id) {

        Candidate candidate = candidateService.getCandidateById(id);
        List<Application> applications = applicationRepository.getAllByCandidateId(id);

        List<ApplicationForListDto> applicationsForListDtos = new ArrayList<>();

        for (Application application : applications) {
            ApplicationForListDto applicationForSave = ApplicationForListDto.builder()
                    .candidateId(id)
                    .desiredPosition(candidate.getDesiredPosition())
                    .expectedSalary(candidate.getExpectedSalary())
                    .city(candidate.getCity())
                    .fio(candidate.getFio())
                    .experience(calculateExperience(candidate))
                    .experienceNumber(calculateExperienceNumber(candidate))
                    .skills(candidate.getSkills())
                    .phone(candidate.getPhone())
                    .email(candidate.getEmail())
                    .telegram(candidate.getTelegram())
                    .applicationId(application.getId())
                    .createdAt(application.getCreatedAt())
                    .comment(application.getComment())
                    .vacancyName(application.getVacancy().getName())
                    .applicationStatus(application.getApplicationStatus())
                    .build();

            applicationsForListDtos.add(applicationForSave);
        }

        return applicationsForListDtos;
    }

    //--------------------utils-------------------//

    private String calculateExperience(Candidate candidate) {

        List<Experience> experiences = candidate.getExperience();
        int sumYears = 0;
        int sumMonths = 0;

        for (Experience experience : experiences) {
            Date start = experience.getStartDate();
            ZonedDateTime zdtStart = start.toInstant().atZone(ZoneId.systemDefault());
            LocalDate startDate = zdtStart.toLocalDate();

            Date end = experience.getEndDate();
            ZonedDateTime zdtEnd = end.toInstant().atZone(ZoneId.systemDefault());
            LocalDate endDate = zdtEnd.toLocalDate();

            Period period = Period.between(startDate, endDate);
            sumYears += period.getYears();
            sumMonths += period.getMonths();

        }

        int years = 0;
        int months = 0;

        if (sumMonths >= 12) {
            int additionalYears = (sumMonths - sumMonths % 12) / 12;
            years = sumYears + additionalYears;
            months = sumMonths % 12;
        } else {
            years = sumYears;
            months = sumMonths;
        }

        if (years % 10 == 1) {
            if (months == 0) {
                return years + " год ";
            } else {
                return years + " год " + months + " мес.";
            }
        } else if (years % 10 == 2) {
            if (months == 0) {
                return years + " года ";
            } else {
                return years + " года " + months + " мес.";
            }
        } else {
            if (months == 0) {
                return years + " лет ";
            } else {
                return years + " лет " + months + " мес.";
            }
        }

    }

    private int calculateExperienceNumber(Candidate candidate) {

        List<Experience> experiences = candidate.getExperience();
        int sumYears = 0;
        int sumMonths = 0;

        for (Experience experience : experiences) {
            Date start = experience.getStartDate();
            ZonedDateTime zdtStart = start.toInstant().atZone(ZoneId.systemDefault());
            LocalDate startDate = zdtStart.toLocalDate();

            Date end = experience.getEndDate();
            ZonedDateTime zdtEnd = end.toInstant().atZone(ZoneId.systemDefault());
            LocalDate endDate = zdtEnd.toLocalDate();

            Period period = Period.between(startDate, endDate);
            sumYears += period.getYears() * 12;
            sumMonths += period.getMonths();

        }

        return sumYears + sumMonths;
    }


}

