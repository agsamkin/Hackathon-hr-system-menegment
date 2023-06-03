package hackathon.ru.data.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDto {

    @NotBlank(message = "city name should not be Empty")
    private String name;

}
