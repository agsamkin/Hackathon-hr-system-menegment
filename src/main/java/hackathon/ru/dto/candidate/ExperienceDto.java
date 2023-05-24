package hackathon.ru.dto.candidate;

import lombok.*;

import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceDto {
    @NotBlank(message = "Company name should not be Empty")
    private String companyName;

    @NotBlank(message = "Position name should not be Empty")
    private String positionName;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "Start date should not be Empty")
    private Date startDate;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "End Date should not be Empty")
    private Date endDate;

    @NotBlank(message = "Description should not be Empty")
    private String description;

    @NotNull(message = "Candidate should not be Empty")
    private Long candidateIds;
}
