package hackathon.ru.data.dto.calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    // TODO: Так плохо + надо refresh token. Для демки решили оставить так
    private String oauth2token;
}
