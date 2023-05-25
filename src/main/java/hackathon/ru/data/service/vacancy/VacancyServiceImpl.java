package hackathon.ru.data.service.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyDto;
import hackathon.ru.data.dto.vacancy.VacancyForListDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.model.vacancy.RequiredExperience;
import hackathon.ru.data.model.vacancy.Vacancy;
import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.data.repository.VacancyRepository;
import hackathon.ru.data.service.CityService;
import hackathon.ru.data.service.user.iService.UserService;
import hackathon.ru.data.service.vacancy.iService.RequiredExperienceService;
import hackathon.ru.data.service.vacancy.iService.VacancyService;
import hackathon.ru.data.service.vacancy.iService.VacancyStatusService;
import hackathon.ru.data.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final CityService cityService;
    private final UserService userService;
    private final VacancyStatusService vacancyStatusService;
    private final WorkFormatService workFormatService;
    private final RequiredExperienceService requiredExperienceService;

    @Override
    public Vacancy getVacancyById(Long id) {
        return null;
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return new ArrayList<>(vacancyRepository.findAll());
    }

    @Override
    public List<VacancyForListDto> getVacancyList() {
        List<Vacancy> vacancies = getAllVacancies();
        List<VacancyForListDto> vacancyDtosForList = new ArrayList<>();
        for (Vacancy vacancy: vacancies) {
            VacancyForListDto vacancyForListDto = VacancyForListDto.builder()
                    .id(vacancy.getId())
                    .name(vacancy.getName())
                    .requiredExperience(vacancy.getRequiredExperience().getName())
                    .city(vacancy.getCity().getName())
                    .workFormat(vacancy.getWorkFormat().getName())
                    .build();
            vacancyDtosForList.add(vacancyForListDto);
        }
        return vacancyDtosForList;

    }

    @Override
    public Vacancy createVacancy(VacancyDto vacancyDto) {
        System.out.println(vacancyDto.toString());
        System.out.println(vacancyDto.getCityId());
        City city = cityService.getCityById(vacancyDto.getCityId());
        System.out.println(city.getName());
        User owner = userService.getUserById(vacancyDto.getOwnerId());
        VacancyStatus vacancyStatus = vacancyStatusService.getVacancyStatusById(vacancyDto.getVacancyStatusId());
        WorkFormat workFormat = workFormatService.getWorkFormatById(vacancyDto.getWorkFormatId());
        RequiredExperience requiredExperience = requiredExperienceService
                .getRequiredExperienceById(vacancyDto.getWorkFormatId());

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
                .city(city)
                .hr(userService.getCurrentUser())
                .owner(owner)
                .vacancyStatus(vacancyStatus)
                .workFormat(workFormat)
                .requiredExperience(requiredExperience)
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
