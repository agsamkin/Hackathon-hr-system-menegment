package hackathon.ru.data.service.vacancy;

import hackathon.ru.data.model.vacancy.WorkFormat;
import hackathon.ru.data.repository.WorkFormatRepository;
import hackathon.ru.data.service.vacancy.iService.WorkFormatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class WorkFormatServiceImpl implements WorkFormatService {

    private final WorkFormatRepository workFormatRepository;

    @Override
    public WorkFormat getWorkFormatById(Long id) {
        return workFormatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("WorkFormat with this id is not found"));
    }

    @Override
    public List<WorkFormat> getAllWorkFormats() {
        return workFormatRepository.findAll();
    }



}
