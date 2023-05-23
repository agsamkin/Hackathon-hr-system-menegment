package hackaton.ru.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {

    private String expectedSalary;

    private String description;

    private Date birthday;

    private String resumeUrl;

    private Long userId;

    private List<Long> applicationsIds;
}
