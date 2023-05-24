package hackathon.ru.service.iService;


import hackathon.ru.dto.candidate.CandidateDto;
import hackathon.ru.model.candidate.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate getCandidateById(Long id);
    List<Candidate> getCandidates();
    Candidate createCandidate(CandidateDto candidateDto);
    Candidate updateCandidate(Long id, CandidateDto candidateDto);
    void deleteCandidate(Long id);
}
