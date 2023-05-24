package hackathon.ru.dto.application;

import hackathon.ru.model.application.enums.StatusApplication;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationStatusDto {

/*    @NotNull(message = "Name should not be empty")
    private String name;*/

    @NotNull(message = "Name should not be empty")
    @Enumerated(EnumType.STRING)
    private StatusApplication statusApplication;

}
