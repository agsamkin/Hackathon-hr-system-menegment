package hackathon.ru.data.dto.candidate;

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
    @NotBlank(message = "company name should not be Empty")
    private String companyName;

    @NotBlank(message = "position name should not be Empty")
    private String positionName;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "start date should not be Empty")
    private Date startDate;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "end Date should not be Empty")
    private Date endDate;

    @NotBlank(message = "description should not be Empty")
    private String description;

    @NotNull(message = "candidate should not be Empty")
    private Long candidateIds;
}
