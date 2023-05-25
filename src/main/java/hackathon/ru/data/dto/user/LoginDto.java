package hackathon.ru.data.dto.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {
    @NotBlank(message = "email should not be Empty")
    @Email(message = "Incorrect Email")
    private String email;

    @NotBlank(message = "password should not be Empty")
    @Size(min = 3, max = 100, message = "password should be between at 3 to 100 symbols")
    private String password;
}
