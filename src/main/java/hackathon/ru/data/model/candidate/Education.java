package hackathon.ru.data.model.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
Класс завершен
 */

@Entity
@Table(name = "education")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "University should not be Empty")
    @Column(name = "university")
    private String university;

    @NotBlank(message = "Graduation year should not be Empty")
    @Column(name = "graduation_year")
    private Integer graduationYear;

    @NotBlank(message = "Specialization salary should not be Empty")
    @Column(name = "specialization")
    private String specialization;

    //связи
    @JsonIgnore
    @NotNull(message = "Degree should not be Empty")
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private Degree degree;

    @JsonIgnore
    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

}
