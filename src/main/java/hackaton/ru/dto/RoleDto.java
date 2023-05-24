package hackaton.ru.dto;

import hackaton.ru.model.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

/*    @NotEmpty(message = "name should not be empty")
    private String name;*/

    @NotEmpty(message = "name should not be empty")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
