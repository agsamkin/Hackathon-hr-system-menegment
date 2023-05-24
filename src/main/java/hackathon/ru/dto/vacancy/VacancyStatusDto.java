package hackathon.ru.dto.vacancy;

import hackathon.ru.model.vacancy.Vacancy;
import hackathon.ru.model.vacancy.enams.StatusVacancy;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyStatusDto {


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private StatusVacancy statusVacancy;

    //    связи

    @OneToMany(mappedBy = "vacancyStatus")
    private List<Vacancy> vacancies;
}
