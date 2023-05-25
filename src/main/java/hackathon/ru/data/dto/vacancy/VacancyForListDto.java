package hackathon.ru.data.dto.vacancy;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyForListDto {
    private Long id;

    private String name;

    private String requiredExperience;

    private String city;

    private String workFormat;
}
