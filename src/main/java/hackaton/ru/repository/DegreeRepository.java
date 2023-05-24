package hackaton.ru.repository;

import hackaton.ru.model.candidate.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
