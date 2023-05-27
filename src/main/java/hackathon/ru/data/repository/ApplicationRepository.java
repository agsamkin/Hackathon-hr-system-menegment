package hackathon.ru.data.repository;


import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.candidate.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> getAllByCandidateId(Long id);

}
