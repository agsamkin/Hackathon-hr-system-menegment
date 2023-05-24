package hackathon.ru.repository;

import hackathon.ru.model.candidate.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
