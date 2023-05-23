package hackaton.ru.model.vacancy;

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

    @OneToMany(mappedBy = "vacancyStatus")
    private List<Vacancy> vacancies;
}
