package hackathon.ru.data.dto.vacancy;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkFormatDto {


    @NotBlank(message = "work format name should not be empty")
    private String name;

}
