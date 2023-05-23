package hackaton.ru.model;

import hackaton.ru.model.candidate.Candidate;
import hackaton.ru.model.user.User;
import hackaton.ru.model.vacancy.Vacancy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City Name should not be Empty")
    @Column(name = "name")
    private String name;

    //    связи

    @OneToMany(mappedBy = "city")
    private List<User> users;

    @OneToMany(mappedBy = "city")
    private List<Vacancy> vacancies;

    @OneToMany(mappedBy = "city")
    private List<Candidate> candidates;
}
