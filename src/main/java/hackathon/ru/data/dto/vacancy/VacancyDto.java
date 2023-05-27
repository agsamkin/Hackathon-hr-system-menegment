package hackathon.ru.data.dto.vacancy;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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
