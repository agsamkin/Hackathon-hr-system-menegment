package hackathon.ru.dto.vacancy;


import hackathon.ru.model.vacancy.enams.FormatOfWork;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkFormatDto {


/*    @NotBlank(message = "Work Format Name should not be Empty")
    @Column(name = "name")
    private String name;*/

    @Enumerated(EnumType.STRING)
    private FormatOfWork formatOfWork;

    //    связи

    private List<Long> vacanciesIds;
}
