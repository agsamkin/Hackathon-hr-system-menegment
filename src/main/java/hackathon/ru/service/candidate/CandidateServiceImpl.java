package hackathon.ru.service.candidate;

import hackathon.ru.data.dto.candidate.custom.CandidateCardDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.custom.CandidateForListDto;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.model.candidate.Education;
import hackathon.ru.data.model.candidate.Experience;
import hackathon.ru.data.repository.CandidateRepository;
import hackathon.ru.data.repository.EducationRepository;
import hackathon.ru.data.repository.ExperienceRepository;
import hackathon.ru.service.CityService;
import hackathon.ru.service.Utils;
import hackathon.ru.service.candidate.iservice.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CityService cityService;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Candidate with this id is not found"));
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return new ArrayList<>(candidateRepository.findAll());
    }

    @Override
    public Candidate createNewCandidate(CandidateDto candidateDto) {
        City city = cityService.getCityById(candidateDto.getCityId());
        Candidate candidate = Candidate.builder()
                .desiredPosition(candidateDto.getDesiredPosition())
                .expectedSalary(candidateDto.getExpectedSalary())
                .birthday(candidateDto.getBirthday())
                .firstName(candidateDto.getFirstName())
                .midName(candidateDto.getMidName())
                .lastName(candidateDto.getLastName())
                .fio(Utils.parseFio(candidateDto))
                .email(candidateDto.getEmail())
                .phone(candidateDto.getPhone())
                .telegram(candidateDto.getTelegram())
                .skills(candidateDto.getSkills())
                .description(candidateDto.getDescription())
                .city(city)
                .build();
        System.out.println(candidate.toString());

        return candidateRepository.save(candidate);
    }


    @Override
    public Candidate updateCandidate(Long id, CandidateDto candidateDto) {
        final Candidate candidateToUpdate = getCandidateById(id);
        City city = cityService.getCityById(candidateDto.getCityId());

        candidateToUpdate.setExpectedSalary(candidateDto.getExpectedSalary());
        candidateToUpdate.setDesiredPosition(candidateDto.getDesiredPosition());
        candidateToUpdate.setBirthday(candidateDto.getBirthday());
        candidateToUpdate.setFirstName(candidateDto.getFirstName());
        candidateToUpdate.setMidName(candidateDto.getMidName());
        candidateToUpdate.setLastName(candidateDto.getLastName());
        candidateToUpdate.setFio(Utils.parseFio(candidateDto));
        candidateToUpdate.setEmail(candidateDto.getEmail());
        candidateToUpdate.setPhone(candidateDto.getPhone());
        candidateToUpdate.setTelegram(candidateDto.getTelegram());
        candidateToUpdate.setSkills(candidateDto.getSkills());
        candidateToUpdate.setDescription(candidateDto.getDescription());
        candidateToUpdate.setCity(city);

        return candidateRepository.save(candidateToUpdate);
    }


    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }


    //-----------DTO-----------//

    @Override
    public List<CandidateForListDto> getListOfCandidates() {

        List<Candidate> allCandidates = getAllCandidates();
        List<CandidateForListDto> candidateList = new ArrayList<>();

        for (Candidate candidate : allCandidates) {
            CandidateForListDto candidateForSave = CandidateForListDto.builder()
                    .id(candidate.getId())
                    .desiredPosition(candidate.getDesiredPosition())
                    .expectedSalary(candidate.getExpectedSalary())
                    .city(candidate.getCity())
                    .fio(candidate.getFio())
                    .skills(candidate.getSkills())
                    .phone(candidate.getPhone())
                    .email(candidate.getEmail())
                    .telegram(candidate.getTelegram())
                    .experienceNumber(Utils.calculateExperienceNumber(candidate))
                    .experience(Utils.calculateExperience(candidate))
                    .build();

            System.out.println(candidateForSave.toString());


            candidateList.add(candidateForSave);
        }

        return candidateList;
    }

    @Override
    public CandidateCardDto getCandidateCardById(Long id) {
        Candidate candidate = getCandidateById(id);
        List<Education> educations = educationRepository.getAllByCandidateId(id);
        List<Experience> experiences = experienceRepository.getAllByCandidateId(id);

        return CandidateCardDto.builder()
                .id(candidate.getId())
                .age(Utils.calculateAge(candidate.getBirthday()))
                .expectedSalary(candidate.getExpectedSalary())
                .desiredPosition(candidate.getDesiredPosition())
                .city(candidate.getCity())
                .skills(candidate.getSkills())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .midName(candidate.getMidName())
                .phone(candidate.getPhone())
                .telegram(candidate.getTelegram())
                .email(candidate.getEmail())
                .description(candidate.getDescription())
                .educations(Utils.convertEdToEdDto(educations))
                .experiences(Utils.convertExpToExpDto(experiences))
                .experience(Utils.calculateExperience(candidate))
                .experienceNumber(Utils.calculateExperienceNumber(candidate))
                .build();
    }



}
