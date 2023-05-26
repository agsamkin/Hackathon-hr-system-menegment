package hackathon.ru.data.repository;

import hackathon.ru.data.dto.candidate.CandidateListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateListRepository extends JpaRepository<CandidateListDto, Long> {
}
