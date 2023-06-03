package hackathon.ru.data.dto.candidate.outputDto;

import lombok.*;

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
