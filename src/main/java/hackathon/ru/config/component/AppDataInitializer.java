package hackathon.ru.config.component;

//@Component
//@AllArgsConstructor
//public class AppDataInitializer {
//    private final DataSource dataSource;
//    private final ApplicationStatusService applicationStatusService;
//    private final CityService cityService;
//    private final DegreeService degreeService;
//    private final RequiredExperienceService requiredExperienceService;
//    private final RoleService roleService;
//    private final VacancyStatusService vacancyStatusService;
//    private final WorkFormatService workFormatService;
//    private final UserService userService;
//    private final VacancyService vacancyService;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void initData() {
//        if (vacancyStatusService.getAllVacancyStatuses().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_vacancy_statuses.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (applicationStatusService.getAllApplicationStatuses().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_application_status.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (cityService.getAllCities().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_city.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (degreeService.getAllDegrees().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_degree.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (requiredExperienceService.getAllRequiredExperiences().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_required_experience.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (roleService.getAllRoles().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_role.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//        if (workFormatService.getAllWorkFormats().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/dictionaries/insert_work_format.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//
//        if (userService.getAllUsers().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/data/insert_user.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//
//        if (vacancyService.getAllVacancies().isEmpty()) {
//            ResourceDatabasePopulator resourceDatabasePopulator
//                    = new ResourceDatabasePopulator(false, false,
//                    "UTF-8", new ClassPathResource("sql/data/insert_vacancy.sql"));
//            resourceDatabasePopulator.execute(dataSource);
//        }
//
//    }
//
//}

