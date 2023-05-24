package hackaton.ru.dto.vacancy;

import hackaton.ru.model.vacancy.StatusVacancy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacancyStatusDto {

/*    @NotEmpty(message = "name should not be empty")
    private String name;*/

    @NotEmpty(message = "name should not be empty")
    @Enumerated(EnumType.STRING)
    private StatusVacancy statusVacancy;
}
