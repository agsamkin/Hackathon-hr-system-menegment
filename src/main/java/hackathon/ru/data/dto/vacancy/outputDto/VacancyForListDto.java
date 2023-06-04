package hackathon.ru.data.dto.vacancy.outputDto;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.data.model.vacancy.WorkFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyForListDto {
    private Long id;
    private String name;
    private String unitName;
    private Integer publicSalary;
    private RequiredExperience requiredExperience;
    private City city;
    private WorkFormat workFormat;
}
