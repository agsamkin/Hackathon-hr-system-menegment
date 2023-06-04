package hackathon.ru.data.dto.candidate.outputDto;

import hackathon.ru.data.model.City;
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
public class CandidateForListDto {

    private Long id;

    private String desiredPosition;

    private int expectedSalary;

    private City city; // город кандидата

    //    заполняется на беке парсингом
    private String fio;

    private String experience;

    private Integer experienceNumber;

    private String skills;

    private String phone;

    private String email;

    private String telegram;
}
