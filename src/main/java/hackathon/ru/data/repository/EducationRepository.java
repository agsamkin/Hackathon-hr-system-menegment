package hackathon.ru.data.repository;

import hackathon.ru.data.model.candidate.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByCandidateId(Long id);
}
