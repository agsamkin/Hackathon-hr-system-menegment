package hackathon.ru.data.dto.application.outputDto;

import hackathon.ru.data.dto.candidate.outputDto.EducationForCandidateCardDto;
import hackathon.ru.data.dto.candidate.outputDto.ExperienceForCandidateCardDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationForCardDto {

    // from Candidate model
    private Long candidateId;
    private int expectedSalary;
    private City city;
    private String firstName;
    private String midName;
    private String lastName;
    private String age;
    private Integer ageNumber;
    private String experience;
    private Integer experienceNumber;
    private String skills;
    private String phone;
    private String email;
    private String telegram;
    private String description;

    //from application model
    private Long applicationId;
    private Date createdAt;
    private String comment;
    private String vacancyName; //from Vacancy vacancy;
    private ApplicationStatus applicationStatus;
    private List<ExperienceForCandidateCardDto> experiences;
    private List<EducationForCandidateCardDto> educations;

}
