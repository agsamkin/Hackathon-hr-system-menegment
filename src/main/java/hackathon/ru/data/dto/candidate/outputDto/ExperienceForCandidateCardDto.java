package hackathon.ru.data.dto.candidate.outputDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceForCandidateCardDto {
    private Long id;
    private String companyName;
    private String positionName;
    private Date startDate;
    private Date endDate;
    private String description;

}
