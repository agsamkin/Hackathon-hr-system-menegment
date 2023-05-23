package hackaton.ru.repository;


import hackaton.ru.model.vacancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyStatusRepository extends JpaRepository<Vacancy, Long> {
}
