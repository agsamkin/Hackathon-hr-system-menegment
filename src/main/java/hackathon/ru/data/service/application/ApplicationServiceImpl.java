package hackathon.ru.data.service.application;

import hackathon.ru.data.dto.application.ApplicationDto;

import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.dto.application.ApplicationForCardDto;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.repository.ApplicationRepository;
import hackathon.ru.data.repository.EducationRepository;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.data.service.application.iService.ApplicationService;
import hackathon.ru.data.service.application.iService.ApplicationStatusService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;

import hackathon.ru.data.service.candidate.iservice.EducationService;
import hackathon.ru.data.service.vacancy.iService.VacancyService;

import hackathon.ru.data.service.Utils;

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
    private final EducationService educationService;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;

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
                    .experience(Utils.calculateExperience(candidate))
                    .experienceNumber(Utils.calculateExperienceNumber(candidate))
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


    @Override
    public ApplicationForCardDto getApplicationForCardDto(Long id) {

        Application application = getApplicationById(id);
        Candidate candidate = application.getCandidate();

        List<Education> educations = educationRepository.getAllByCandidateId(candidate.getId());
        List<Experience> experiences = experienceRepository.getAllByCandidateId(candidate.getId());

        return ApplicationForCardDto.builder()
                .candidateId(id)
                .expectedSalary(candidate.getExpectedSalary())
                .city(candidate.getCity())
                .firstName(candidate.getFirstName())
                .midName(candidate.getMidName())
                .lastName(candidate.getLastName())
                .age(Utils.calculateAge(candidate.getBirthday()))
                .ageNumber(Utils.calculateAgeNumber(candidate.getBirthday()))
                .experience(Utils.calculateExperience(candidate))
                .experienceNumber(Utils.calculateExperienceNumber(candidate))
                .skills(candidate.getSkills())
                .description(candidate.getDescription())
                .phone(candidate.getPhone())
                .email(candidate.getEmail())
                .telegram(candidate.getTelegram())

                .applicationId(application.getId())
                .createdAt(application.getCreatedAt())
                .comment(application.getComment())
                .vacancyName(application.getVacancy().getName())
                .applicationStatus(application.getApplicationStatus())
                .educations(Utils.convertEdToEdDto(educations))
                .experiences(Utils.convertExpToExpDto(experiences))
                .build();

    }

}

