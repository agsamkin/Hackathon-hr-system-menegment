package hackathon.ru.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.model.vacancy.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
