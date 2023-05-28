package hackathon.ru.service.vacancy;

import hackathon.ru.data.dto.vacancy.VacancyStatusDto;
import hackathon.ru.data.model.vacancy.VacancyStatus;
import hackathon.ru.data.repository.VacancyStatusRepository;
import hackathon.ru.service.vacancy.iService.VacancyStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class VacancyStatusServiceImpl implements VacancyStatusService {
    private final VacancyStatusRepository vacancyStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public VacancyStatus getVacancyStatusById(Long id) {
        return vacancyStatusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("vacancy with that id is not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VacancyStatus> getAllVacancyStatuses() {
        return vacancyStatusRepository.findAll();
    }

    @Override
    public VacancyStatus createVacancyStatus(VacancyStatusDto vacancyStatusDto) {
        VacancyStatus vacancyStatus = VacancyStatus.builder()
                .name(vacancyStatusDto.getName())
                .build();
        return vacancyStatusRepository.save(vacancyStatus);
    }

    @Override
    public VacancyStatus updateVacancyStatus(Long id, VacancyStatusDto vacancyStatusDto) {
        return null;
    }

    @Override
    public void deleteVacancyStatusById(Long id) {

    }
}
