package hackaton.ru.model.user;

import hackaton.ru.model.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

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

    @NotBlank(message = "Role Name should not be Empty")
    @Column(name = "name")
    private String name;

//    связи

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
