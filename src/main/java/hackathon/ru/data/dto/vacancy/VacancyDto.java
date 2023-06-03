package hackathon.ru.data.dto.vacancy;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDto {
    @NotBlank(message = "vacancy name should not be Empty")
    private String name;

    @NotBlank(message = "unit name should not be Empty")
    private String unitName;

    @NotNull(message = "min salary should not be Empty")
    private Integer minSalary;

    @NotNull(message = "max salary should not be Empty")
    private Integer maxSalary;

    @Lob
    @NotNull(message = "public salary should not be Empty")
    private Integer publicSalary;

    @Lob
    @NotBlank(message = "description should not be Empty")
    private String description;

    @Lob
    @NotBlank(message = "requirement should not be Empty")
    private String requirements;

    @Lob
    @NotBlank(message = "responsibility should not be Empty")
    private String responsibilities;

    @Lob
    @NotBlank(message = "benefit should not be Empty")
    private String benefits;

    @NotBlank(message = "skills should not be Empty")
    private String skills;

    @NotNull(message = "cityId should not be Empty")
    private Long cityId;

    private Long hrId;

    private Long ownerId;

    private Long vacancyStatusId;

    @NotNull(message = "work format id should not be Empty")
    private Long workFormatId;

    @NotNull(message = "required experience id should not be Empty")
    private Long requiredExperienceId;

// Статус вакансии и автор вакансии заполняются
// автоматически(статус новая, автор текущий пользователь)
}
