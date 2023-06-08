package hackathon.ru.data.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDto {

    private String comment;

    @NotNull(message = "vacancyId should not be empty")
    private Long vacancyId;

    @NotNull(message = "candidateId should not be empty")
    private Long candidateId;

    private Long applicationStatusId;
    // статус назначается автоматически как новая.

}

