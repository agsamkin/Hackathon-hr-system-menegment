package hackathon.ru.model.candidate;

import hackathon.ru.model.candidate.enums.DegreeStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @NotBlank(message = "Degree name should not be Empty")
    @Column(name = "name")
    private String name;*/

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private DegreeStatus degreeStatus;

//    связи

    @OneToMany(mappedBy = "degree")
    private List<Education> educations;
}
