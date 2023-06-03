package hackathon.ru.data.repository;

import hackathon.ru.data.model.calendar.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    Calendar getByCalendarId(String calendarId);
    Optional<Calendar> findByUserId(Long id);
}
