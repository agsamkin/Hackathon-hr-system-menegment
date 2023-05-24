package hackaton.ru.dto.application;

import hackaton.ru.model.application.StatusApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatusDto {

/*    @NotNull(message = "Name should not be empty")
    private String name;*/

    @NotNull(message = "Name should not be empty")
    @Enumerated(EnumType.STRING)
    private StatusApplication statusApplication;

}
