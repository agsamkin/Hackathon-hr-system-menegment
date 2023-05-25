package hackathon.ru.data.service.candidate.iservice;


import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.model.candidate.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate getCandidateById(Long id);
    List<Candidate> getCandidates();
    Candidate createCandidate(CandidateDto candidateDto);
    Candidate updateCandidate(Long id, CandidateDto candidateDto);
    void deleteCandidate(Long id);
}
