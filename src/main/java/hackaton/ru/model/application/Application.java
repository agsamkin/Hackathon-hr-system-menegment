package hackaton.ru.model.application;

import hackaton.ru.model.candidate.Candidate;
import hackaton.ru.model.vacancy.Vacancy;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/*
Класс завершен
 */


@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "comment")
    private String comment;


    @ManyToOne
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")
    private Vacancy vacancy;

    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @NotNull(message = "Application status should not be Empty")
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ApplicationStatus applicationStatus;
}
