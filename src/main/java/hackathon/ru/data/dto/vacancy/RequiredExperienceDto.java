package hackathon.ru.data.dto.vacancy;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequiredExperienceDto {

    @NotBlank(message = "required Experience Name should not be Empty")
    private String name;

}
