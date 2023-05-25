package hackathon.ru.data.repository;


import hackathon.ru.data.model.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
