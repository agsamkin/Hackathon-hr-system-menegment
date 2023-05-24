package hackaton.ru.dto.vacancy;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDto {

    private String name;

    private String experience;

    private String minSalary;

    private String maxSalary;

    private String publicSalary;

    private String description;

    private String requirement;

    private String responsibility;

    private String benefit;


    private Long cityId;

    private Long userId;

    private Long vacancyStatusId;

    private List<Long> applicationsId;

// Статус вакансии и автор вакансии заполняются автоматически(статус новая, автор текущий пользователь)
}
