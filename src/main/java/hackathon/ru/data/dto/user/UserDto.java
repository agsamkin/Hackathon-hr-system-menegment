package hackathon.ru.data.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @NotBlank(message = "email should not be Empty")
    @Email(message = "Incorrect Email")
    private String email;

    @NotBlank(message = "password should not be Empty")
    @Size(min = 3, max = 100, message = "Password should be between at 3 to 100 symbols")
    private String password;

    @NotBlank(message = "first Name should not be Empty")
    private String firstName;

    @NotBlank(message = "last Name should not be Empty")
    private String lastName;

    @NotBlank(message = "phone Number should not be Empty")
    private String phone;
    @NotNull
    private Long cityId;
    @NotNull
    private Long roleId;
}

