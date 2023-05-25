package hackathon.ru.data.model.candidate;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/*
Класс завершен
 */

@Entity
@Table(name = "experience")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name should not be Empty")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Position name should not be Empty")
    @Column(name = "position_name")
    private String positionName;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "Start date should not be Empty")
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "End Date should not be Empty")
    @Column(name = "end_date")
    private Date endDate;

    @NotBlank(message = "Description should not be Empty")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
}
