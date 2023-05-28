package hackathon.ru.data.dto.user.customDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
