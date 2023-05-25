package hackathon.ru.data.repository;

import hackathon.ru.data.model.candidate.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
