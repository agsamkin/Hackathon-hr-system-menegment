package hackathon.ru.service;

import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.outputDto.EducationForCandidateCardDto;
import hackathon.ru.data.dto.candidate.outputDto.ExperienceForCandidateCardDto;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {
    public static String calculateAge(Date birthDay) {
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

    public static Integer calculateAgeNumber(Date birthDay) {
        LocalDate now = LocalDate.now();
        ZonedDateTime zdt = birthDay.toInstant().atZone(ZoneId.systemDefault());
        LocalDate birth = zdt.toLocalDate();

        if (birth.isAfter(now) || birth.isEqual(now)) {
            throw new IllegalArgumentException("Неверная дата рождения");
        }

        return Period.between(birth, now).getYears();
    }

    public static String calculateExperience(Candidate candidate) {

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

    public static int calculateExperienceNumber(Candidate candidate) {

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

    public static String parseFio(CandidateDto candidateDto) {
        return candidateDto.getLastName() + " " +
                candidateDto.getFirstName().charAt(0) + ". " +
                candidateDto.getMidName().charAt(0) + ".";
    }

    public static List<EducationForCandidateCardDto> convertEdToEdDto(List<Education> educations) {
        List<EducationForCandidateCardDto> educationsForCandidateCardDto = new ArrayList<>();

        for (Education education : educations) {
            EducationForCandidateCardDto educationForCandidateCardDto = EducationForCandidateCardDto.builder()
                    .id(education.getId())
                    .university(education.getUniversity())
                    .graduationYear(education.getGraduationYear())
                    .specialization(education.getSpecialization())
                    .degree(education.getDegree())
                    .build();

            educationsForCandidateCardDto.add(educationForCandidateCardDto);
        }
        return educationsForCandidateCardDto;
    }

    public static List<ExperienceForCandidateCardDto> convertExpToExpDto(List<Experience> experiences) {
        List<ExperienceForCandidateCardDto> experiencesForCandidateCardDto = new ArrayList<>();

        for (Experience experience : experiences) {
            ExperienceForCandidateCardDto experienceForCandidateCardDto = ExperienceForCandidateCardDto.builder()
                    .id(experience.getId())
                    .companyName(experience.getCompanyName())
                    .positionName(experience.getPositionName())
                    .startDate(experience.getStartDate())
                    .endDate(experience.getEndDate())
                    .description(experience.getDescription())
                    .build();


            experiencesForCandidateCardDto.add(experienceForCandidateCardDto);
        }
        return experiencesForCandidateCardDto;
    }
}
