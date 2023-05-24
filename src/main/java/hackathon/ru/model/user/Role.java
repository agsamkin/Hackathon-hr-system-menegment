package hackathon.ru.model.user;

import hackathon.ru.model.user.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
Класс завершен
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*  @NotBlank(message = "Role Name should not be Empty")
    @Column(name = "name")
    private String name;*/ // это не надо вроде

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

//    связи

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
