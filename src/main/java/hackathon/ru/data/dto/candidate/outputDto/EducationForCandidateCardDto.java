package hackathon.ru.data.dto.candidate.outputDto;

import hackathon.ru.data.model.candidate.Degree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationForCandidateCardDto {
    private Long id;
    private String university;
    private Integer graduationYear;
    private String specialization;
    private Degree degree;
}
