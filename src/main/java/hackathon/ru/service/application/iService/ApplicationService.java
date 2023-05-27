package hackathon.ru.service.application.iService;



import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.dto.application.ApplicationForCardDto;
import hackathon.ru.data.dto.application.customDto.ApplicationResponseDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ApplicationVacancyCandidateDto;
import hackathon.ru.data.model.application.Application;
import java.util.List;

public interface ApplicationService {
    Application getApplicationById(Long id);
    List<Application> getAllApplications();
    ApplicationResponseDto createApplication(ApplicationVacancyCandidateDto applicationVacancyCandidateDto);
    Application updateApplication(Long id, ApplicationDto applicationDto);
    void deleteApplicationById(Long id);
    List<ApplicationForListDto> getListOfCandidateApplication(Long id);

    ApplicationForCardDto getApplicationForCardDto(Long id);
}
