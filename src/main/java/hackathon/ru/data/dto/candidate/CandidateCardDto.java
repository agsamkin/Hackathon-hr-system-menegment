package hackathon.ru.data.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateCardDto {

    @NotBlank(message = "Expected salary should not be Empty")
    private int expectedSalary;

    @NotNull(message = "City should not be Empty")
    private Long cityId;

    private String age;

    @NotBlank(message = "First Name should not be empty")
    private String firstName;

    @NotBlank(message = "Mid Name should not be empty")
    private String midName;

    @NotBlank(message = "Last Name should not be empty")
    private String lastName;

    private String experience;

    private int experienceNumber;

    @NotBlank(message = "Skills should not be empty")
    private String skills;

    private List<Long> educationsIds;
    private List<Long> experiencesIds;

    @NotBlank(message = "Email should not be empty")
    @Email(message = "Incorrect Email")
    private String email;

    @NotBlank(message = "Phone should not be empty")
    private String phone;

    @NotBlank(message = "Telegram should not be empty")
    private String telegram;

    @Lob
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