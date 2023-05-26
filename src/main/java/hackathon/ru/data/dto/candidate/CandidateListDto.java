package hackathon.ru.data.dto.candidate;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateListDto {

    private String desiredPosition;

    private int expectedSalary;

    private City city; // город кандидата

    private String vacancyName;

    private List<Application> applications;

    //    заполняется на беке парсингом
    private String fio;

    private String experience;

    private Integer experienceNumber;

    private String skills;

    private String phone;

    private String email;

    private String telegram;

}
