package hackathon.ru.dto.user;

import hackathon.ru.model.user.enums.UserRole;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

//    связи

    private List<Long> usersIds;

}
