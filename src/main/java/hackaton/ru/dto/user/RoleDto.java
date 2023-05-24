package hackaton.ru.dto.user;

import hackaton.ru.model.user.enums.UserRole;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

/*    @NotEmpty(message = "name should not be empty")
    private String name;*/

    @NotEmpty(message = "name should not be empty")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
