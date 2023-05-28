package hackathon.ru.service.vacancy;

import hackathon.ru.data.dto.vacancy.WorkFormatDto;
import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.data.repository.WorkFormatRepository;
import hackathon.ru.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class WorkFormatServiceImpl implements WorkFormatService {

    private final WorkFormatRepository workFormatRepository;

    @Override
    @Transactional(readOnly = true)
    public WorkFormat getWorkFormatById(Long id) {
        return workFormatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("WorkFormat with this id is not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkFormat> getAllWorkFormats() {
        return workFormatRepository.findAll();
    }

    @Override
    public WorkFormat createWorkFormat(WorkFormatDto workFormatDto) {
        WorkFormat workFormat = WorkFormat.builder()
                .name(workFormatDto.getName())
                .build();
        return workFormatRepository.save(workFormat);
    }


}
