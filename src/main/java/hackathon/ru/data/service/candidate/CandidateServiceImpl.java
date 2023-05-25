package hackathon.ru.data.service.candidate;


import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.repository.CandidateRepository;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("candidate with that id is not found"));
    }

    @Override
    public List<Candidate> getCandidates() {
        return new ArrayList<>(candidateRepository.findAll());
    }

    @Override
    public Candidate createCandidate(CandidateDto candidateDto) {
        return null;
    }

    @Override
    public Candidate updateCandidate(Long id, CandidateDto candidateDto) {
        return null;
    }

    @Override
    public void deleteCandidate(Long id) {

    }
}
