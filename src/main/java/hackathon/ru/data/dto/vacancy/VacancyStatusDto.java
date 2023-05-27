package hackathon.ru.data.dto.vacancy;

import hackathon.ru.data.model.vacancy.Vacancy;
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
    private String name;

    //    связи

    @OneToMany(mappedBy = "vacancyStatus")
    private List<Vacancy> vacancies;
}
