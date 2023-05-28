package hackathon.ru.data.repository;

import hackathon.ru.data.model.calendar.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
