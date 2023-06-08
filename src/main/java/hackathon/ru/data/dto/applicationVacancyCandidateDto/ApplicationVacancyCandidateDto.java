package hackathon.ru.data.dto.applicationVacancyCandidateDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hackathon.ru.data.dto.candidate.inputDto.EducationFromFrontDto;
import hackathon.ru.data.dto.candidate.inputDto.ExperienceFromFrontDto;
import hackathon.ru.data.model.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationVacancyCandidateDto {
    //    Данные Вакансии.
    @NotNull
    private Long vacancyId;

    //    Данные Кандидата
    @NotNull(message = "Expected salary should not be Empty")
    private Integer expectedSalary;
    @NotBlank(message = "desired position should not be empty")
    private String desiredPosition;
    @NotNull(message = "Birthday should not be Empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date birthday;
    @NotBlank(message = "First Name should not be Empty")
    private String firstName;
    @NotBlank(message = "Mid Name should not be Empty")
    private String midName;
    @NotBlank(message = "Last Name should not be Empty")
    private String lastName;
    @NotBlank(message = "email should not be Empty")
    @Email(message = "Incorrect Email")
    private String email;
    @NotBlank(message = "phone should not be Empty")
    private String phone;
    @NotBlank(message = "telegram should not be Empty")
    private String telegram;
    @NotBlank(message = "skills should not be Empty")
    private String skills;
    @Lob
    private String description;
    @NotNull(message = "city should not be Empty")
    private City city;
    //    Данные по образованию
    private List<EducationFromFrontDto> educations;
    //    Опыт работы
    private List<ExperienceFromFrontDto> experiences;
}

