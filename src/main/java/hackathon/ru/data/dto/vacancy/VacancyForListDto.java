package hackathon.ru.data.dto.vacancy;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.data.model.vacancy.WorkFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyForListDto {
    private Long id;
    private String name;
    private String unitName;
    private RequiredExperience requiredExperience;
    private City city;
    private WorkFormat workFormat;
}
