package hackathon.ru.data.dto.candidate;

import hackathon.ru.data.model.candidate.Candidate;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDto {

    @NotBlank(message = "university should not be Empty")
    private String university;

    @NotBlank(message = "graduation year should not be Empty")
    private Integer graduationYear;

    @NotBlank(message = "specialization salary should not be Empty")
    private String specialization;

    @NotNull(message = "degree should not be Empty")
    private Long degreeIds;

    @NotNull(message = "candidate should not be Empty")
    private Long candidateIds;
}
