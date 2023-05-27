package hackathon.ru.repository;

import hackathon.ru.data.model.vacancy.WorkFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkFormatRepository extends JpaRepository<WorkFormat, Long> {
}
