package hackathon.ru.data.model.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "vacancy_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //    связи
    @JsonIgnore
    @OneToMany(mappedBy = "vacancyStatus")
    private List<Vacancy> vacancies;
}
