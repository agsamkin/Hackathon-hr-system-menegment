package hackathon.ru.data.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DegreeDto {

    @NotBlank(message = "name should not be Empty")
    private String name;

//    связи
    private List<Long> educationsIds;

}
