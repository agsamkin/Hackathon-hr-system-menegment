package hackathon.ru.repository;

import hackathon.ru.model.vacancy.RequiredExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequiredExperienceRepository extends JpaRepository<RequiredExperience, Long> {
}
