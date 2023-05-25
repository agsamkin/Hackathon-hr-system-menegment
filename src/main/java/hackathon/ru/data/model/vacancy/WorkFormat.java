package hackathon.ru.data.model.vacancy;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "workFormat")
    private List<Vacancy> vacancies;
}
