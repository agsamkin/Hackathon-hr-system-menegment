package hackathon.ru.data.service.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyCardForCandidateDto;
import hackathon.ru.data.dto.vacancy.VacancyCardForHrDto;
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
    public Vacancy createVacancy(VacancyDto vacancyDto) {
        City city = cityService.getCityById(vacancyDto.getCityId());
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
        City city = cityService.getCityById(vacancyDto.getCityId());
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
                .vacancyStatus(vacancyStatus)
                .workFormat(workFormat)
                .requiredExperience(requiredExperience)
                .build();

        return vacancyRepository.save(vacancy);
    }

    @Override
    public void deleteVacancyById(Long id) {
        vacancyRepository.deleteById(id);
    }

    //    получить список вакансий для кандидата
    @Override
    public List<VacancyForListDto> getVacanciesListForCandidates() {
//        получаем только открытые вакансии для кандидатов
        List<Vacancy> vacancies = vacancyRepository.getVacanciesByVacancyStatusName("открыта");
        List<VacancyForListDto> listVacancyForListDto = new ArrayList<>();

        for (Vacancy vacancy : vacancies) {
            VacancyForListDto vacancyForListDto = VacancyForListDto.builder()
                    .id(vacancy.getId())
                    .name(vacancy.getName())
                    .requiredExperience(vacancy.getRequiredExperience())
                    .city(vacancy.getCity())
                    .workFormat(vacancy.getWorkFormat())
                    .build();
            listVacancyForListDto.add(vacancyForListDto);
        }
        return listVacancyForListDto;
    }

    //    получить список вакансий для hr(только его вакансии
    @Override
    public List<VacancyForListDto> getVacanciesListForHr() {
        List<Vacancy> vacancies = vacancyRepository.getVacanciesByHrId(userService.getCurrentUser().getId());
        List<VacancyForListDto> listVacancyForListDto = new ArrayList<>();
        for (Vacancy vacancy : vacancies) {
            VacancyForListDto vacancyForListDto = VacancyForListDto.builder()
                    .id(vacancy.getId())
                    .name(vacancy.getName())
                    .requiredExperience(vacancy.getRequiredExperience())
                    .city(vacancy.getCity())
                    .workFormat(vacancy.getWorkFormat())
                    .build();
            listVacancyForListDto.add(vacancyForListDto);
        }
        return listVacancyForListDto;
    }

    // карточка вакансии которую просматривает кандидат
    @Override
    public VacancyCardForCandidateDto getVacancyCardForCandidateById(Long id) {
        Vacancy vacancy = getVacancyById(id);

        return VacancyCardForCandidateDto.builder()
                .id(vacancy.getId())
                .name(vacancy.getName())
                .publicSalary(vacancy.getPublicSalary())
                .description(vacancy.getDescription())
                .requirements(vacancy.getRequirements())
                .requirements(vacancy.getResponsibilities())
                .benefits(vacancy.getBenefits())
                .skills(vacancy.getSkills())
                .city(vacancy.getCity())
                .requiredExperience(vacancy.getRequiredExperience())
                .workFormat(vacancy.getWorkFormat())
                .build();
    }


    @Override
    public VacancyCardForHrDto getVacancyCardForHrById(Long id) {
        Vacancy vacancy = getVacancyById(id);

        return VacancyCardForHrDto.builder()
                .id(vacancy.getId())
                .minSalary(vacancy.getMinSalary())
                .maxSalary(vacancy.getMaxSalary())
                .publicSalary(vacancy.getPublicSalary())
                .description(vacancy.getDescription())
                .requirements(vacancy.getRequirements())
                .responsibilities(vacancy.getResponsibilities())
                .benefits(vacancy.getBenefits())
                .skills(vacancy.getSkills())
                .owner(vacancy.getOwner())
                .vacancyStatus(vacancy.getVacancyStatus())
                .workFormat(vacancy.getWorkFormat())
                .requiredExperience(vacancy.getRequiredExperience())
                .build();
    }


}
