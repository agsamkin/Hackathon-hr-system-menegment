package hackathon.ru.data.dto.vacancy;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDto {


    @NotBlank(message = "vacancy Name should not be Empty")
    private String name;

    @NotBlank(message = "min Salary should not be Empty")
    private String minSalary;

    @NotBlank(message = "max Salary should not be Empty")
    private String maxSalary;

    @NotBlank(message = "public Salary should not be Empty")
    private String publicSalary;

    @NotBlank(message = "description should not be Empty")
    private String description;

    @NotBlank(message = "requirement should not be Empty")
    private String requirements;

    @NotBlank(message = "responsibility should not be Empty")
    private String responsibilities;

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

    @Override
    public String toString() {
        return "VacancyDto{" +
                "name='" + name + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", publicSalary='" + publicSalary + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", benefits='" + benefits + '\'' +
                ", skills='" + skills + '\'' +
//                ", cityId=" + cityId +
                ", hrId=" + hrId +
                ", ownerId=" + ownerId +
                ", vacancyStatusId=" + vacancyStatusId +
                ", workFormatId=" + workFormatId +
                ", requiredExperienceId=" + requiredExperienceId +
                ", applicationsIds=" + applicationsIds +
                '}';
    }

// Статус вакансии и автор вакансии заполняются
// автоматически(статус новая, автор текущий пользователь)
}
