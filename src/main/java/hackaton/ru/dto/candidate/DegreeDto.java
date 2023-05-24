package hackaton.ru.dto.candidate;

import hackaton.ru.model.candidate.Education;
import hackaton.ru.model.candidate.enums.DegreeStatus;
import lombok.*;

import javax.persistence.*;
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
    private List<Education> educations;

}
