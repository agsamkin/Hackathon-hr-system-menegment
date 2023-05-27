package hackathon.ru.repository;


import hackathon.ru.data.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}

