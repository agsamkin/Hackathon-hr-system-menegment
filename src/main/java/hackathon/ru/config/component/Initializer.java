package hackathon.ru.config.component;

import hackathon.ru.data.service.CityService;
import hackathon.ru.data.service.application.iService.ApplicationStatusService;
import hackathon.ru.data.service.candidate.iservice.DegreeService;
import hackathon.ru.data.service.user.iService.RoleService;
import hackathon.ru.data.service.vacancy.iService.RequiredExperienceService;
import hackathon.ru.data.service.vacancy.iService.VacancyStatusService;
import hackathon.ru.data.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@AllArgsConstructor
public class Initializer {
    private final DataSource dataSource;
    private final ApplicationStatusService applicationStatusService;
    private final CityService cityService;
    private final DegreeService degreeService;
    private final RequiredExperienceService requiredExperienceService;
    private final RoleService roleService;
    private final VacancyStatusService vacancyStatusService;
    private final WorkFormatService workFormatService;

    @EventListener(ApplicationReadyEvent.class)
    public void initAppData() {
        if (vacancyStatusService.getAllVacancyStatuses().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_vacancy_statuses.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (applicationStatusService.getAllApplicationStatuses().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_application_status.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (cityService.getAllCities().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_city.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (degreeService.getAllDegrees().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_degree.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (requiredExperienceService.getAllRequiredExperiences().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_required_experience.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (roleService.getAllRoles().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_role.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
        if (workFormatService.getAllWorkFormats().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_work_format.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
    }
}

