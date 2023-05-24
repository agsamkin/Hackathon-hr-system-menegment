package hackathon.ru.dto.vacancy;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDto {


    @NotBlank(message = "Vacancy Name should not be Empty")
    private String name;

    @NotBlank(message = "Min Salary should not be Empty")
    private String minSalary;

    @NotBlank(message = "Max Salary should not be Empty")
    private String maxSalary;

    @NotBlank(message = "Public Salary should not be Empty")
    private String publicSalary;

    @NotBlank(message = "Description should not be Empty")
    private String description;

    @NotBlank(message = "Requirement should not be Empty")
    private String requirements;

    @NotBlank(message = "Responsibility should not be Empty")
    private String responsibilities;

    @NotBlank(message = "Benefit should not be Empty")
    private String benefits;

    @NotBlank(message = "Skills should not be Empty")
    private String skills;

    @NotNull(message = "City should not be Empty")
    private Long cityId;

    private Long hrId;

    private Long ownerId;

    private Long vacancyStatusId;

    private Long workFormatId;

    private Long requiredExperienceId;

//    связи

    private List<Long> applicationsIds;

// Статус вакансии и автор вакансии заполняются
// автоматически(статус новая, автор текущий пользователь)
}
