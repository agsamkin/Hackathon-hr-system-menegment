package hackathon.ru.dto.candidate;

import hackathon.ru.model.candidate.enums.DegreeStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DegreeDto {

    @Enumerated(EnumType.STRING)
    private DegreeStatus degreeStatus;

//    связи
    private List<Long> educationsIds;

}
