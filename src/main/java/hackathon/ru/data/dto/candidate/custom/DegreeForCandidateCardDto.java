package hackathon.ru.data.dto.candidate.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DegreeForCandidateCardDto {

    private String name;

/*    //    связи
    @JsonIgnore
    @OneToMany(mappedBy = "degree")
    private List<Education> educations;*/
}
