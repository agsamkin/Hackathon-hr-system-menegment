package hackathon.ru.data.model.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "application_status")
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

    @JsonIgnore
    @OneToMany(mappedBy = "applicationStatus")
    private List<Application> applications;
}
