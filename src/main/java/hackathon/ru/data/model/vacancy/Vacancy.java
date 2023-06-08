package hackathon.ru.data.model.vacancy;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "vacancy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "vacancy name should not be empty")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "unit name should not be empty")
    @Column(name = "unit_name")
    private String unitName;

    @NotNull(message = "min salary should not be empty")
    @Column(name = "min_salary")
    private Integer minSalary;

    @NotNull(message = "max salary should not be empty")
    @Column(name = "max_salary")
    private Integer maxSalary;

    @NotNull(message = "public salary should not be empty")
    @Column(name = "public_salary")
    private Integer publicSalary;

    @Lob
    @NotBlank(message = "description should not be empty")
    @Column(name = "description")
    private String description;

    @Lob
    @NotBlank(message = "requirement should not be empty")
    @Column(name = "requirements")
    private String requirements;

    @Lob
    @NotBlank(message = "responsibility should not be empty")
    @Column(name = "responsibilities")
    private String responsibilities;

    @Lob
    @NotBlank(message = "benefit should not be empty")
    @Column(name = "benefits")
    private String benefits;

    @NotBlank(message = "skills should not be empty")
    @Column(name = "skills")
    private String skills;

    @NotNull(message = "city should not be empty")
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @NotNull(message = "hr should not be empty")
    @ManyToOne
    @JoinColumn(name = "hr_id", referencedColumnName = "id")
    private User hr;

    @NotNull(message = "owner should not be empty")
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @NotNull(message = "vacancy status should not be empty")
    @ManyToOne()
    @JoinColumn(name = "vacancy_status_id", referencedColumnName = "id")
    private VacancyStatus vacancyStatus;

    @NotNull(message = "work format should not be empty")
    @ManyToOne()
    @JoinColumn(name = "work_format_id", referencedColumnName = "id")
    private WorkFormat workFormat;

    @NotNull(message = "required experience should not be empty")
    @ManyToOne()
    @JoinColumn(name = "required_experience_id", referencedColumnName = "id")
    private RequiredExperience requiredExperience;

//    связи

    @JsonIgnore
    @OneToMany(mappedBy = "vacancy")
    private List<Application> applications;
}
