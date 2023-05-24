package hackaton.ru.dto.candidate;

import hackaton.ru.model.City;
import hackaton.ru.model.application.Application;
import hackaton.ru.model.candidate.Education;
import hackaton.ru.model.candidate.Experience;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDto {


    @NotBlank(message = "Expected salary should not be Empty")
    private String expectedSalary;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "Birthday should not be Empty")
    private Date birthday;

    @NotBlank(message = "First Name should not be Empty")
    private String firstName;

    @NotBlank(message = "Mid Name should not be Empty")
    private String midName;

    @NotBlank(message = "Last Name should not be Empty")
    private String lastName;

    //    заполняется на беке парсингом
    private String fio;

    @NotBlank(message = "Email should not be Empty")
    @Email(message = "Incorrect Email")
    private String email;

    @NotBlank(message = "Phone should not be Empty")
    private String phone;

    @NotBlank(message = "Telegram should not be Empty")
    private String telegram;

    @NotBlank(message = "Skills should not be Empty")
    private String skills;

    @Lob
    private String description;

    @NotNull(message = "City should not be Empty")
    private Long cityId;

//    связи

    private List<Long> educationsId;

    private List<Long> experiencesId;

    private List<Long> applicationsId;
}
