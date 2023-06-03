package hackathon.ru.service.application.iService;



import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationForListDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationForCardDto;
import hackathon.ru.data.dto.application.outputDto.ApplicationCreatedDto;
import hackathon.ru.data.dto.application.inputDto.CommentDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ApplicationVacancyCandidateDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    Application getApplicationById(Long id);
    List<ApplicationForListDto> getAllApplications();
    ApplicationCreatedDto createApplication(ApplicationVacancyCandidateDto applicationVacancyCandidateDto);
    Application updateApplication(Long id, ApplicationDto applicationDto);
    void deleteApplicationById(Long id);
    List<ApplicationForListDto> getListOfCandidateApplication(Long id);
    ApplicationStatus updateApplicationStatus(Long applicationId, ApplicationStatus applicationStatus);
    CommentDto updateApplicationComment(Long applicationId, CommentDto commentDto);
    ApplicationForCardDto getApplicationForCardDto(Long id);
}
