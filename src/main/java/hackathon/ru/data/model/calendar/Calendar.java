package hackathon.ru.data.model.calendar;

import hackathon.ru.data.model.user.User;

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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calendars")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calendar_id")
    private String calendarId;

    @Column(name = "summery")
    private String summery;

    @Lob
    @Column(name = "description")
    private String description;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

//    @JsonIgnore
    @OneToMany(mappedBy = "calendar", cascade = ALL)
    private List<Event> events;
}
