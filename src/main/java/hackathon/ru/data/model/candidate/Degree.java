package hackathon.ru.data.model.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "degree")
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
