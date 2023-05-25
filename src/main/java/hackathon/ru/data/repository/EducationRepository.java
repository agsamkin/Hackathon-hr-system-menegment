package hackathon.ru.data.repository;

import hackathon.ru.data.model.candidate.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
