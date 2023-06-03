package hackathon.ru.data.model.candidate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "candidate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first Name should not be empty")
    @Column(name = "desired_position")
    private String desiredPosition;

    @NotNull(message = "expected salary should not be empty")
    @Column(name = "expected_salary")
    private int expectedSalary;

    @Temporal(TIMESTAMP)
    @NotNull(message = "birthday should not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    @Column(name = "birthday")
    private Date birthday;

    @NotBlank(message = "first Name should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "mid Name should not be empty")
    @Column(name = "Mid_name")
    private String midName;

    @NotBlank(message = "last Name should not be empty")
    @Column(name = "last_name")
    private String lastName;

    //    заполняется на беке парсингом
    @Column(name = "fio")
    private String fio;

    @NotBlank(message = "email should not be empty")
    @Email(message = "incorrect Email")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "phone should not be empty")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "telegram should not be empty")
    @Column(name = "Telegram")
    private String telegram;

    @NotBlank(message = "skills should not be empty")
    @Column(name = "skills")
    private String skills;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull(message = "city should not be empty")
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
