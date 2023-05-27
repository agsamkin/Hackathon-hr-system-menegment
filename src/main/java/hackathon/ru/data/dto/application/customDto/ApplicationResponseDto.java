package hackathon.ru.data.dto.application.customDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponseDto {
    boolean isCreated;
    String message;
}
