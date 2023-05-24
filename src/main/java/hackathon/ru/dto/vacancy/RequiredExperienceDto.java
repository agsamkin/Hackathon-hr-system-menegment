package hackathon.ru.dto.vacancy;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequiredExperienceDto {

    @NotBlank(message = "Required Experience Name should not be Empty")
    private String name;

    //    связи

    private List<Long> vacanciesIds;
}
