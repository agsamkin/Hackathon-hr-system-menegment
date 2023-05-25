package hackathon.ru.data.dto.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private String userRole;

//    связи

    private List<Long> usersIds;

}
