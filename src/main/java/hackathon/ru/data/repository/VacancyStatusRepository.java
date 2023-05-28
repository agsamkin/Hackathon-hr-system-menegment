package hackathon.ru.data.repository;


import hackathon.ru.data.model.vacancy.VacancyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyStatusRepository extends JpaRepository<VacancyStatus, Long> {
}
