package hackathon.ru.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.model.vacancy.Vacancy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "city")
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
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Vacancy> vacancies;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Candidate> candidates;
}
