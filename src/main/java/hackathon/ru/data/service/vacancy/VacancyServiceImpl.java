package hackathon.ru.data.service.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.VacancyListDto;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.repository.VacancyRepository;
import hackathon.ru.data.service.vacancy.iService.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public Vacancy getVacancyById(Long id) {
        return null;
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return new ArrayList<>(vacancyRepository.findAll());
    }

    public List<VacancyListDto> getVacanciesForList(){
        return null;
    }

    @Override
    public Vacancy createVacancy(VacancyDto vacancyDto) {
        Vacancy vacancy = Vacancy.builder()
                .name(vacancyDto.getName())
                .minSalary(vacancyDto.getMinSalary())
                .maxSalary(vacancyDto.getMaxSalary())
                .publicSalary(vacancyDto.getPublicSalary())
                .description(vacancyDto.getDescription())
                .requirements(vacancyDto.getRequirements())
                .responsibilities(vacancyDto.getResponsibilities())
                .benefits(vacancyDto.getBenefits())
                .skills(vacancyDto.getSkills())
                .build();

        return vacancyRepository.save(vacancy);

    }

    @Override
    public Vacancy updateVacancy(Long id, VacancyDto vacancyDto) {
        return null;
    }

    @Override
    public void deleteVacancyById(Long id) {

    }
}
