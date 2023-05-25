package hackathon.ru.data.model.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "work_format")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //    связи
    @JsonIgnore
    @OneToMany(mappedBy = "workFormat")
    private List<Vacancy> vacancies;
}
