package hackathon.ru.repository;

import hackathon.ru.data.model.calendar.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>  {
}
