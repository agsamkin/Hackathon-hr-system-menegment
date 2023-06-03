package hackathon.ru.data.model.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "required_experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequiredExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Required Experience Name should not be Empty")
    @Column(name = "name")
    private String name;

    //    связи

    @JsonIgnore
    @OneToMany(mappedBy = "requiredExperience")
    private List<Vacancy> vacancies;
}
