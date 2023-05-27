package hackathon.ru.config.component;

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
    private final VacancyStatusService vacancyStatusService;
    private final WorkFormatService workFormatService;
    private final RequiredExperienceService requiredExperienceService;


    @EventListener(ApplicationReadyEvent.class)
    public void initAppData() {
        if (vacancyStatusService.getAllVacancyStatuses().isEmpty()) {

            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/insert_vacancy_statuses.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
    }
}
