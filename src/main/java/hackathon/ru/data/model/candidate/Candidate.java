package hackathon.ru.data.model.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.City;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

/*
Класс завершен
 */

@Entity
@Table(name = "candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name should not be empty")
    @Column(name = "desired_position")
    private String desiredPosition;

    @NotBlank(message = "Expected salary should not be empty")
    @Column(name = "expected_salary")
    private int expectedSalary;

    @Temporal(TIMESTAMP)
    @NotBlank(message = "Birthday should not be empty")
    @Column(name = "birthday")
    private Date birthday;

    @NotBlank(message = "First Name should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Mid Name should not be empty")
    @Column(name = "Mid_name")
    private String midName;

    @NotBlank(message = "Last Name should not be empty")
    @Column(name = "last_name")
    private String lastName;

    //    заполняется на беке парсингом
    @Column(name = "fio")
    private String fio;

    @NotBlank(message = "Email should not be empty")
    @Email(message = "Incorrect Email")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Phone should not be empty")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Telegram should not be empty")
    @Column(name = "Telegram")
    private String telegram;

    @NotBlank(message = "Skills should not be empty")
    @Column(name = "skills")
    private String skills;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull(message = "City should not be empty")
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

//    связи

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Education> education;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experience;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Application> applications;
}
