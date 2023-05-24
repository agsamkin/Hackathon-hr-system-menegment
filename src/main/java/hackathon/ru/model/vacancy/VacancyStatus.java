package hackathon.ru.model.vacancy;

import hackathon.ru.model.vacancy.enams.StatusVacancy;
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

/*    @Column(name = "name")
    private String name;*/

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private StatusVacancy statusVacancy;

    //    связи

    @OneToMany(mappedBy = "vacancyStatus")
    private List<Vacancy> vacancies;
}
