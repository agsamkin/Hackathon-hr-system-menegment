package hackathon.ru.data.dto.candidate;

import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateCardDto {

    private String desiredPosition;

    private List<Application> applications;

    private int expectedSalary;

    private City city;

    private String age;

    private String firstName;

    private String midName;

    private String lastName;

    private String experience;

    private int experienceNumber; // отправить в месяцах.

    private String skills;

    private List<Education> educations;

    private List<Experience> experiences;

    private String email;

    private String phone;

    private String telegram;

    private String description;

}


/*
соответственно для получения карточки вакансии нужен метод с id

для получения списка фильтры

но пока что можно просто весь список выводить

и нужна будет сортировка по возрастанию и убыванию у списка кандидатов:
по ожидаемой зп
по стажу
по наиболее актуальным для данной вакансии (нужен алгоритм)
*/