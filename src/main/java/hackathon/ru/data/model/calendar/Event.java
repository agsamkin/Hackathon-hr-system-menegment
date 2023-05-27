package hackathon.ru.data.model.calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private String eventId;

    @JsonIgnore
    @Column(name = "creator")
    private String creator;

    @JsonIgnore
    @Column(name = "organizer")
    private String organizer;

    @Temporal(TIMESTAMP)
    @Column(name = "start")
    private Date start;

    @Temporal(TIMESTAMP)
    @Column(name = "end")
    private Date end;

    @Lob
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Column(name = "html_link")
    private String htmlLink;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @Temporal(TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @JsonIgnore
    @Temporal(TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

//    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = ALL, fetch = FetchType.EAGER)
    private List<Attendee> attendees;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    private Calendar calendar;
}
