package hackathon.ru.data.repository;

import hackathon.ru.data.model.candidate.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
