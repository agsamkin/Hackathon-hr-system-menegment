package hackathon.ru.data.repository;


import hackathon.ru.data.model.vacancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findVacanciesByHrId(Long id);
    List<Vacancy> findVacanciesByVacancyStatusName(String name);
}
