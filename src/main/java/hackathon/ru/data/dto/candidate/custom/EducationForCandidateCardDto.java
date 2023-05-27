package hackathon.ru.data.dto.candidate.custom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Degree;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationForCandidateCardDto {

    private String university;
    private Integer graduationYear;
    private String specialization;

/*    //связи
    @JsonIgnore
    @NotNull(message = "Degree should not be Empty")
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private Degree degree;

    @JsonIgnore
    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;*/
}
