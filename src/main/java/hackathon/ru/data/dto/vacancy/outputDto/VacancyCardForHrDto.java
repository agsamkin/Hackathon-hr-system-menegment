package hackathon.ru.data.dto.vacancy.outputDto;

import hackathon.ru.data.model.user.User;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.data.model.vacancy.WorkFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyCardForHrDto {
    private Long id;
    private String name;
    private String unitName;
    private Integer minSalary;
    private Integer maxSalary;
    private Integer publicSalary;
    private String description;
    private String requirements;
    private String responsibilities;
    private String benefits;
    private String skills;
    private User owner;
    private VacancyStatus vacancyStatus;
    private WorkFormat workFormat;
    private RequiredExperience requiredExperience;
}
