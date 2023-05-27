package hackathon.ru.data.model.application;

import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.vacancy.Vacancy;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/*
Класс завершен
 */


@Entity
@Table(name = "application")
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


//    Под вопросом
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
