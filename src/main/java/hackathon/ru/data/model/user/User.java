package hackathon.ru.data.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.vacancy.Vacancy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

/*
Класс завершен
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email should not be Empty")
    @Email(message = "Incorrect Email")
    @Column(name = "email", unique = true)
    private String email;

    @JsonIgnore
    @NotBlank(message = "Password should not be Empty")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "First Name should not be Empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name should not be Empty")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Phone should not be Empty")
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    //    связи

    @JsonIgnore
    @OneToMany(mappedBy = "hr")
    private List<Vacancy> vacanciesAuthor;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Vacancy> vacanciesOwner;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = ALL)
    private Calendar calendar;
}
