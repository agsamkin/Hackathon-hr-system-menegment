package hackathon.ru.data.dto.candidate;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateListDto {
    private int expectedSalary;

    private City city; // город кандидата

    private String vacancyName;

    private Application application;

    //    заполняется на беке парсингом
    private String fio;

    private String experience;

    private Integer experienceNumber;

    private String skills;

    private String phone;

    private String email;

    private String telegram;

}
/* еще наименование вакансии вытащить, на которую был отклик и дату отклика*/