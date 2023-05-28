package hackathon.ru.data.repository;


import hackathon.ru.data.model.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> getAllByCandidateId(Long id);
    Optional<Application> findApplicationByCandidateIdAndVacancyId(Long candidateId, Long vacancyId);

}
