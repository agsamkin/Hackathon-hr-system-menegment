package hackaton.ru.dto.vacancy;

import hackaton.ru.model.vacancy.enams.StatusVacancy;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyStatusDto {

/*    @NotEmpty(message = "name should not be empty")
    private String name;*/

    @NotEmpty(message = "name should not be empty")
    @Enumerated(EnumType.STRING)
    private StatusVacancy statusVacancy;
}
