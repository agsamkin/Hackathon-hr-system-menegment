package hackathon.ru.data.repository;

import hackathon.ru.data.dto.candidate.CandidateCardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateCardRepository extends JpaRepository<CandidateCardDto, Long> {
}
