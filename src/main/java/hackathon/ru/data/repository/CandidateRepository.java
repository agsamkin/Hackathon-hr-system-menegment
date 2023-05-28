package hackathon.ru.data.repository;


import hackathon.ru.data.model.candidate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findAllByEmail(String email);
}
