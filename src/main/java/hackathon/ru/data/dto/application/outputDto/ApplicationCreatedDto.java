package hackathon.ru.data.dto.application.outputDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationCreatedDto {
    boolean isCreated;
    String message;
}
