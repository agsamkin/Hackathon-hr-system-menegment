package hackathon.ru.data.dto.application;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationStatusDto {

    @NotNull(message = "Name should not be empty")
    private String name;

}
