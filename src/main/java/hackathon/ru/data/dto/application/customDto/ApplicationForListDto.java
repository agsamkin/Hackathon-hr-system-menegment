package hackathon.ru.data.dto.application.customDto;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.ApplicationStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationForListDto {

    // from Candidate model
    private Long candidateId;
    private String desiredPosition;
    private int expectedSalary;
    private City city; // город кандидата
    private String fio; // заполняется на беке парсингом
    private String experience;
    private Integer experienceNumber;
    private String skills;
    private String phone;
    private String email;
    private String telegram;

    //from application model
    private Long applicationId;
    private Date createdAt;
    private String comment;
    private String vacancyName; //from Vacancy vacancy;
    private ApplicationStatus applicationStatus;


}
