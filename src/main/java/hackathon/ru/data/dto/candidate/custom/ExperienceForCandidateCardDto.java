package hackathon.ru.data.dto.candidate.custom;

import hackathon.ru.data.model.candidate.Candidate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

public class ExperienceForCandidateCardDto {

    private String companyName;

    private String positionName;

    private Date startDate;

    private Date endDate;

    private String description;

/*
    @NotNull(message = "Candidate should not be Empty")
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;*/
}
