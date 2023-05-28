package hackathon.ru.service.application;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.ApplicationForCardDto;
import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.dto.application.customDto.ApplicationResponseDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ApplicationVacancyCandidateDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.EducationFromFrontDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ExperienceFromFrontDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.EducationDto;
import hackathon.ru.data.dto.candidate.ExperienceDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.repository.ApplicationRepository;
import hackathon.ru.data.repository.CandidateRepository;
import hackathon.ru.data.repository.EducationRepository;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.service.Utils;
import hackathon.ru.service.application.iService.ApplicationService;
import hackathon.ru.service.application.iService.ApplicationStatusService;
import hackathon.ru.service.candidate.iservice.CandidateService;
import hackathon.ru.service.candidate.iservice.EducationService;
import hackathon.ru.service.candidate.iservice.ExperienceService;
import hackathon.ru.service.vacancy.iService.VacancyService;
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
    private final ExperienceService experienceService;
    private final CandidateRepository candidateRepository;

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Application with that id is not found"));
    }

    @Override
    public List<ApplicationForListDto> getAllApplications() {
        List<Application> applications =  new ArrayList<>(applicationRepository.findAll());
        List<ApplicationForListDto> applicationForListDtos = new ArrayList<>();
        for (Application application: applications) {
            Candidate candidate = application.getCandidate();

            ApplicationForListDto applicationForSave = ApplicationForListDto.builder()
                    .candidateId(candidate.getId())
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

            applicationForListDtos.add(applicationForSave);
        }
        return applicationForListDtos;
    }

    @Override
    public ApplicationResponseDto createApplication(ApplicationVacancyCandidateDto applicationVacancyCandidateDto) {
        Vacancy vacancy = vacancyService.getVacancyById(applicationVacancyCandidateDto.getVacancyId());

        ApplicationResponseDto applicationResponseDto = ChainExistCheck(
                applicationVacancyCandidateDto.getVacancyId(),
                applicationVacancyCandidateDto.getEmail());

        if (!applicationResponseDto.isCreated()) {
            return applicationResponseDto;
        }

        CandidateDto candidateDto = CandidateDto.builder()
                .expectedSalary(applicationVacancyCandidateDto.getExpectedSalary())
                .desiredPosition(applicationVacancyCandidateDto.getDesiredPosition())
                .birthday(applicationVacancyCandidateDto.getBirthday())
                .firstName(applicationVacancyCandidateDto.getFirstName())
                .midName(applicationVacancyCandidateDto.getMidName())
                .lastName(applicationVacancyCandidateDto.getLastName())
                .email(applicationVacancyCandidateDto.getEmail())
                .phone(applicationVacancyCandidateDto.getPhone())
                .telegram(applicationVacancyCandidateDto.getTelegram())
                .skills(applicationVacancyCandidateDto.getSkills())
                .description(applicationVacancyCandidateDto.getDescription())
                .cityId(applicationVacancyCandidateDto.getCity().getId())
                .build();

        Candidate candidate;
        if (candidateRepository.findAllByEmail(applicationVacancyCandidateDto.getEmail()).isPresent()) {
            Long candidateId = candidateRepository.findAllByEmail(candidateDto.getEmail()).get().getId();
            candidate = candidateService.updateCandidate(candidateId, candidateDto);
        } else {
            candidate = candidateService.createNewCandidate(candidateDto);
        }
        Long candidateId = candidate.getId();


        List<EducationFromFrontDto> educationFromFrontDtoList = applicationVacancyCandidateDto.getEducations();
        if (!educationFromFrontDtoList.isEmpty()) {
            for (EducationFromFrontDto educationFromFrontDto : educationFromFrontDtoList) {
                EducationDto educationDto = EducationDto.builder()
                        .university(educationFromFrontDto.getUniversity())
                        .graduationYear(educationFromFrontDto.getGraduationYear())
                        .specialization(educationFromFrontDto.getSpecialization())
                        .degreeId(educationFromFrontDto.getDegree().getId())
                        .candidateId(candidateId)
                        .build();
                educationService.createEducation(educationDto);
            }
        }

        List<ExperienceFromFrontDto> experienceFromFrontDtoList = applicationVacancyCandidateDto.getExperiences();

        if (!experienceFromFrontDtoList.isEmpty()) {
            for (ExperienceFromFrontDto experienceFromFrontDto : experienceFromFrontDtoList) {
                ExperienceDto experienceDto = ExperienceDto.builder()
                        .companyName(experienceFromFrontDto.getCompanyName())
                        .positionName(experienceFromFrontDto.getPositionName())
                        .startDate(experienceFromFrontDto.getStartDate())
                        .endDate(experienceFromFrontDto.getEndDate())
                        .description(experienceFromFrontDto.getDescription())
                        .candidateId(candidateId)
                        .build();
                experienceService.createExperience(experienceDto);
            }
        }

        ApplicationStatus applicationStatus = applicationStatusService.getApplicationStatusById(1L);

        Application application = Application.builder()
                .vacancy(vacancy)
                .candidate(candidate)
                .applicationStatus(applicationStatus)
                .build();

        applicationRepository.save(application);
        return applicationResponseDto;
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

    private ApplicationResponseDto ChainExistCheck(Long vacancyId, String candidateEmail) {
        boolean isExist = false;
        if (candidateRepository.findAllByEmail(candidateEmail).isPresent()) {
            Long candidateId = candidateRepository.findAllByEmail(candidateEmail).get().getId();
            if (applicationRepository.findApplicationByCandidateIdAndVacancyId(candidateId,vacancyId).isPresent()) {
                isExist = true;
            }
        }
        String approve = "Мы обязательно рассмотрим вашу вакансию";
        String fail = "Вы уже откликались на эту вакансию";

        return ApplicationResponseDto.builder()
                .isCreated(isExist? false:true)
                .message(isExist? fail: approve)
                .build();
    }

}

