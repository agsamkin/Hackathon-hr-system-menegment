package hackaton.ru.repository;

import hackaton.ru.model.vacancy.WorkFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkFormatRepository extends JpaRepository<WorkFormat, Long> {
}
