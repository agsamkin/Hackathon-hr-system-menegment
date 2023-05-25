package hackathon.ru.data.repository;

import hackathon.ru.data.model.vacancy.RequiredExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequiredExperienceRepository extends JpaRepository<RequiredExperience, Long> {
}
