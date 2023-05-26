package hackathon.ru.data.model.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Degree name should not be Empty")
    @Column(name = "name")
    private String name;


//    связи
    @JsonIgnore
    @OneToMany(mappedBy = "degree")
    private List<Education> educations;
}
