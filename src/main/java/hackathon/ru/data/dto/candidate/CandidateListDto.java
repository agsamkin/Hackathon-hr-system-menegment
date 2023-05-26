package hackathon.ru.data.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateListDto {
    @NotBlank(message = "Expected salary should not be Empty")
    private int expectedSalary;

    @NotNull(message = "City should not be Empty")
    private Long cityId;

    //    заполняется на беке парсингом
    private String fio;

    private String experience;

    private int experienceNumber;

    @NotBlank(message = "Skills should not be Empty")
    private String skills;

    @NotBlank(message = "Phone should not be Empty")
    private String phone;

    @NotBlank(message = "Email should not be Empty")
    @Email(message = "Incorrect Email")
    private String email;

    @NotBlank(message = "Telegram should not be Empty")
    private String telegram;

}
