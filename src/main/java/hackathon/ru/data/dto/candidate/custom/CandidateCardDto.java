package hackathon.ru.data.dto.candidate.custom;

import hackathon.ru.data.model.City;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateCardDto {

    private Long id;

    private String desiredPosition;

//    private List<Application> applications;

    private int expectedSalary;

    private City city;

    private String age;

    private String firstName;

    private String midName;

    private String lastName;

    private String experience;

    private int experienceNumber; // отправить в месяцах.

    private String skills;

    private List<EducationForCandidateCardDto> educations;

    private List<ExperienceForCandidateCardDto> experiences;

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