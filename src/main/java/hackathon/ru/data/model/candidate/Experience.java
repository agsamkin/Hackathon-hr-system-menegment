package hackathon.ru.data.model.candidate;


import com.fasterxml.jackson.annotation.JsonFormat;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @NotNull(message = "Start Date should not be Empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "End Date should not be Empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
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
