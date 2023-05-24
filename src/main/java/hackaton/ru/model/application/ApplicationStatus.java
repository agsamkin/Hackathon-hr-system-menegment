package hackaton.ru.model.application;

import lombok.*;

import javax.persistence.*;
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

/*    @NotBlank(message = "Status Name should not be Empty")
    @Column(name = "name")
    private String name;*/

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private StatusApplication statusApplication;

//    связи

    @OneToMany(mappedBy = "applicationStatus")
    private List<Application> applications;
}
