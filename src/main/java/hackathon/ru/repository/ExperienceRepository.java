package hackathon.ru.repository;

import hackathon.ru.model.candidate.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
