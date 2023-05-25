package hackathon.ru.data.dto.vacancy;


import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkFormatDto {


    @NotBlank(message = "Work Format Name should not be Empty")
    @Column(name = "name")
    private String name;

    //    связи

    private List<Long> vacanciesIds;
}
