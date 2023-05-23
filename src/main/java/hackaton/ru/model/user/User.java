package hackaton.ru.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hackaton.ru.model.City;
import hackaton.ru.model.candidate.Candidate;
import hackaton.ru.model.vacancy.Vacancy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
    @Size(min = 3, max = 20, message = "Password should be between at 3 to 100 symbols")
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

    @OneToMany(mappedBy = "hr")
    private List<Vacancy> vacanciesAuthor;

    @OneToMany(mappedBy = "owner")
    private List<Vacancy> vacanciesOwner;

}
