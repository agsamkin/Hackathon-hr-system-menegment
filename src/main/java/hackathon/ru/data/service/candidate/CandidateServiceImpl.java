package hackathon.ru.data.service.candidate;

import hackathon.ru.data.dto.candidate.CandidateCardDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.CandidateListDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.repository.CandidateRepository;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.data.service.CityService;
import hackathon.ru.data.service.application.iService.ApplicationService;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    private final ExperienceRepository experienceRepository;
    private final ApplicationService applicationService;


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
                .build();

        return candidateRepository.save(candidate);
    }


    @Override
    public Candidate updateCandidate(Long id, CandidateDto candidateDto) {
        final Candidate candidateToUpdate = getCandidateById(id);
        City city = cityService.getCityById(candidateDto.getCityId());


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
        return null;
    }

    @Override
    public CandidateCardDto getCandidateCardById(Long id) {
        return null;
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

