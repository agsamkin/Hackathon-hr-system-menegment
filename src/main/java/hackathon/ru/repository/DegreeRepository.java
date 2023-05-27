package hackathon.ru.repository;

import hackathon.ru.data.dto.candidate.custom.DegreeForCandidateCardDto;

import hackathon.ru.data.model.candidate.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
    List<DegreeForCandidateCardDto> getAllByEducations(Long id);
}
