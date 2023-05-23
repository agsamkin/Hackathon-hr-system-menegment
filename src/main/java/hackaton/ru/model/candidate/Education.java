package hackaton.ru.model.candidate;

import liquibase.pro.packaged.J;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "educations")
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

    @NotNull(message = "Degree should not be Empty")
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private Degree degree;

    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

}
