package hackathon.ru.data.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.vacancy.Vacancy;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
