package hackaton.ru.model.vacancy;

import hackaton.ru.model.vacancy.enams.FormatOfWork;
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

/*    @NotBlank(message = "Work Format Name should not be Empty")
    @Column(name = "name")
    private String name;*/

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FormatOfWork formatOfWork;

    //    связи

    @OneToMany(mappedBy = "workFormat")
    private List<Vacancy> vacancies;
}
