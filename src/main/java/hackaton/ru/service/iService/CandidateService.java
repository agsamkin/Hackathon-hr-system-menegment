package hackaton.ru.service.iService;


import hackaton.ru.dto.candidate.CandidateDto;
import hackaton.ru.model.candidate.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate getCandidateById(Long id);
    List<Candidate> getCandidates();
    Candidate createCandidate(CandidateDto candidateDto);
    Candidate updateCandidate(Long id, CandidateDto candidateDto);
    void deleteCandidate(Long id);
}
