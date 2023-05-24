package hackaton.ru.repository;

import hackaton.ru.model.candidate.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
