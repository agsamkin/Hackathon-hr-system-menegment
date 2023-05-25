package hackathon.ru.data.repository;


import hackathon.ru.data.model.vacancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyStatusRepository extends JpaRepository<Vacancy, Long> {
}
