package hackathon.ru.service.candidate.iservice;


import hackathon.ru.data.dto.candidate.outputDto.CandidateCardDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.outputDto.CandidateForListDto;
import hackathon.ru.data.model.candidate.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate getCandidateById(Long id);
    List<Candidate> getAllCandidates();
    Candidate createNewCandidate(CandidateDto candidateDto);
    Candidate updateCandidate(Long id, CandidateDto candidateDto);
    void deleteCandidate(Long id);
    List<CandidateForListDto> getListOfCandidates();
    CandidateCardDto getCandidateCardById(Long id);
}
