package hackathon.ru.data.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull(message = "graduation year should not be Empty")
    private Integer graduationYear;

    @NotBlank(message = "specialization salary should not be Empty")
    private String specialization;

    @NotNull(message = "degree should not be Empty")
    private Long degreeId;

    @NotNull(message = "candidate should not be Empty")
    private Long candidateId;
}
