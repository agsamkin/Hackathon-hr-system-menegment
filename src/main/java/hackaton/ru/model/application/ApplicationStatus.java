package hackaton.ru.model.application;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "statuses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Status Name should not be Empty")
    @Column(name = "name")
    private String name;

//    связи

    @OneToMany(mappedBy = "applicationStatus")
    private List<Application> applications;
}
