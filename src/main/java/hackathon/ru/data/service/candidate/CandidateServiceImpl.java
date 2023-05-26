package hackathon.ru.data.service.candidate;

import hackathon.ru.data.dto.candidate.CandidateCardDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.CandidateListDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.repository.CandidateCardRepository;
import hackathon.ru.data.repository.CandidateListRepository;
import hackathon.ru.data.repository.CandidateRepository;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import hackathon.ru.data.service.candidate.iservice.EducationService;
import hackathon.ru.data.service.candidate.iservice.ExperienceService;
import hackathon.ru.data.service.application.iService.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import hackathon.ru.data.service.CityService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CityService cityService;
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final ApplicationService applicationService;
    private final ExperienceRepository experienceRepository;
    private final CandidateCardRepository candidateCardRepository;
    private final CandidateListRepository candidateListRepository;

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Candidate with this id is not found"));
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return new ArrayList<>(candidateRepository.findAll());
    }

    @Override
    public Candidate createNewCandidate(CandidateDto candidateDto) {

        City city = cityService.getCityById(candidateDto.getCityId());
        List<Long> educationsIds = candidateDto.getEducationsIds(); // to List<Education> education;
        List<Long> experiencesIds = candidateDto.getExperiencesIds(); // to List<Experience> experience;
        List<Long> applicationsIds = candidateDto.getApplicationsIds(); // to List<Application> applications;

        List<Education> educations = new ArrayList<>();
        List<Experience> experiences = new ArrayList<>();
        List<Application> applications = new ArrayList<>();

        for(Long educationsId : educationsIds) {
            Education education = educationService.getEducationById(educationsId);
            educations.add(education);
        }

        for(Long experiencesId : experiencesIds) {
            Experience experience = experienceService.getExperienceById(experiencesId);
            experiences.add(experience);
        }

        for(Long applicationsId : applicationsIds) {
            Application application = applicationService.getApplicationById(applicationsId);
            applications.add(application);
        }

        Candidate candidate = Candidate.builder()
                .expectedSalary(candidateDto.getExpectedSalary())
                .birthday(candidateDto.getBirthday())
                .firstName(candidateDto.getFirstName())
                .midName(candidateDto.getMidName())
                .lastName(candidateDto.getLastName())
                .fio(parseFio(candidateDto))
                .email(candidateDto.getEmail())
                .phone(candidateDto.getPhone())
                .telegram(candidateDto.getTelegram())
                .skills(candidateDto.getSkills())
                .description(candidateDto.getDescription())
                .city(city)
                .education(educations)
                .experience(experiences)
                .applications(applications)
                .build();

        return candidateRepository.save(candidate);
    }


    @Override
    public Candidate updateCandidate(Long id, CandidateDto candidateDto) {
        final Candidate candidateToUpdate = candidateRepository.findById(id).get();
        City city = cityService.getCityById(candidateDto.getCityId());
        List<Long> educationsIds = candidateDto.getEducationsIds(); // to List<Education> education;
        List<Long> experiencesIds = candidateDto.getExperiencesIds(); // to List<Experience> experience;
        List<Long> applicationsIds = candidateDto.getApplicationsIds(); // to List<Application> applications;

        List<Education> educations = new ArrayList<>();
        List<Experience> experiences = new ArrayList<>();
        List<Application> applications = new ArrayList<>();

        for(Long educationsId : educationsIds) {
            Education education = educationService.getEducationById(educationsId);
            educations.add(education);
        }

        for(Long experiencesId : experiencesIds) {
            Experience experience = experienceService.getExperienceById(experiencesId);
            experiences.add(experience);
        }

        for(Long applicationsId : applicationsIds) {
            Application application = applicationService.getApplicationById(applicationsId);
            applications.add(application);
        }

        candidateToUpdate.builder()
                .expectedSalary(candidateDto.getExpectedSalary())
                .birthday(candidateDto.getBirthday())
                .firstName(candidateDto.getFirstName())
                .midName(candidateDto.getMidName())
                .lastName(candidateDto.getLastName())
                .fio(parseFio(candidateDto))
                .email(candidateDto.getEmail())
                .phone(candidateDto.getPhone())
                .telegram(candidateDto.getTelegram())
                .skills(candidateDto.getSkills())
                .description(candidateDto.getDescription())
                .city(city)
                .education(educations)
                .experience(experiences)
                .applications(applications)
                .build();

        return candidateRepository.save(candidateToUpdate);
    }


    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);

    }



    //-----------DTO-----------//

    @Override
    public List<CandidateListDto> getAllCandidatesCard() {
        return new ArrayList<>(candidateListRepository.findAll());
    }

    @Override
    public CandidateCardDto getCandidateCardById(Long id) {
        return candidateCardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Candidate with this id is not found"));
    }






    //----------utils---------//
    public String calculateAge(Date birthDay) {
        LocalDate now = LocalDate.now();
        ZonedDateTime zdt = birthDay.toInstant().atZone(ZoneId.systemDefault());
        LocalDate birth = zdt.toLocalDate();

        if (birth.isAfter(now) || birth.isEqual(now)) {
            return "Неверная дата рождения";
        }

        int age = Period.between(birth, now).getYears();

        if (age % 10 == 1) {
            return age + " " + "год";
        } else if (age % 10 == 2) {
            return age + " " + "года";
        } else {
            return age + " " + "лет";
        }
    }

    public String calculateExperience(CandidateDto candidateDto) {

        List<Long> experiencesIds = candidateDto.getExperiencesIds();
        int sumYears = 0;
        int sumMonths = 0;

        for (Long id : experiencesIds) {
            Experience experience = experienceRepository.findById(id)
                    .orElseThrow(()
                            -> new NoSuchElementException("Work experience with this id is not found"));

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
            return years + " год " + months + " мес.";
        } else if (years % 10 == 2) {
            return years + " года " + months + " мес.";
        } else {
            return years + " лет " + months + " мес.";
        }

    }

    public double calculateExperienceNumber(CandidateDto candidateDto) {

        List<Long> experiencesIds = candidateDto.getExperiencesIds();
        double sumYears = 0;
        double sumMonths = 0;

        for (Long id : experiencesIds) {
            Experience experience = experienceRepository.findById(id)
                    .orElseThrow(()
                            -> new NoSuchElementException("Work experience with this id is not found"));

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
        if (sumMonths >= 12) {
            double additionalYears = (sumMonths - sumMonths % 12) / 12;

            return sumYears + additionalYears + (sumMonths % 12) / 12;
        } else {
            return sumYears + sumMonths / 12;
        }


    }

    public String parseFio(CandidateDto candidateDto) {
        return candidateDto.getLastName() + " " +
                candidateDto.getFirstName().charAt(0) + ". " +
                candidateDto.getMidName().charAt(0) + ".";
    }
}

