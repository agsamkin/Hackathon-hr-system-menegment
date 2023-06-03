package hackathon.ru.data.dto.candidate.inputDto;

import hackathon.ru.data.model.candidate.Degree;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationFromFrontDto {
    @NotBlank(message = "university should not be Empty")
    private String university;

    @NotNull(message = "graduation year should not be Empty")
    private Integer graduationYear;

    @NotBlank(message = "specialization salary should not be Empty")
    private String specialization;

    @NotNull(message = "degree should not be Empty")
    private Degree degree;
}
