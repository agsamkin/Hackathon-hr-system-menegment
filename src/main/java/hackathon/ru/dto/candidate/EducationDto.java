package hackathon.ru.dto.candidate;

import hackathon.ru.model.candidate.Candidate;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDto {

    @NotBlank(message = "University should not be Empty")
    private String university;

    @NotBlank(message = "Graduation year should not be Empty")
    private Integer graduationYear;

    @NotBlank(message = "Specialization salary should not be Empty")
    private String specialization;

    @NotNull(message = "Degree should not be Empty")
    private Long degreeIds;

    @NotNull(message = "Candidate should not be Empty")
    private Candidate candidateIds;
}
