package hackathon.ru.controller;

import hackathon.ru.data.dto.candidate.CandidateCardDto;
import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.CandidateListDto;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.data.service.candidate.iservice.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Candidate controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + CandidateController.CANDIDATE_CONTROLLER_PATH)
public class CandidateController {

    public static final String CANDIDATE_CONTROLLER_PATH = "/candidates";
    public static final String ID = "/{id}";
    private final CandidateService candidateService;


    // GET /api/candidates/{id} - получение кандидата по идентификатору
    @Operation(summary = "Get candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidate was found"),
        @ApiResponse(responseCode = "404", description = "Candidate with this ID does not exist")
    })
    @GetMapping(ID)
    public Candidate getCandidateById(@PathVariable("id") final Long id) {
        return candidateService.getCandidateById(id);
    }


    // POST /api/candidates - создание нового кандидата
    @Operation(summary = "Create new candidate")
    @ApiResponse(responseCode = "201", description = "Task created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Candidate createCandidate(
        @Parameter(schema = @Schema(implementation = CandidateDto.class))
        @RequestBody @Valid CandidateDto candidateDto) {
        return candidateService.createNewCandidate(candidateDto);
    }


    // GET /api/candidates - получение списка кандидатов
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Get all candidates")
    @ApiResponse(responseCode = "200", description = "List of candidates was successfully found")
    @GetMapping()
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }


    // PUT /api/candidates/{id} - обновление кандидата
    @Operation(summary = "Update candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidate updated"),
        @ApiResponse(responseCode = "404", description = "Candidate with this ID not found")
    })
    @PutMapping(ID)
    public Candidate updateCandidate(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final CandidateDto candidateDto) {
        return candidateService.updateCandidate(id, candidateDto);
    }


    // DELETE /api/candidates/{id} - удаление кандидата
    @Operation(summary = "Delete candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidate deleted"),
        @ApiResponse(responseCode = "404", description = "Candidate with this ID is not found")
    })
    @DeleteMapping(ID)
    public void deleteCandidate(@PathVariable("id") final Long id) {
        candidateService.deleteCandidate(id);
    }



    //-----------DTO-----------//


    // GET /api/candidates(???) - получение списка кандидатов
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Get all candidates")
    @ApiResponse(responseCode = "200", description = "List of candidates was successfully found")
    @GetMapping()
    public List<CandidateListDto> getAllCandidatesList() {
        return candidateService.getListOfCandidates();
    }


    // GET /api/candidates/{id}(???) - получение кандидата по идентификатору
    @Operation(summary = "Get candidate by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate was found"),
            @ApiResponse(responseCode = "404", description = "Candidate with this ID does not exist")
    })
    @GetMapping(ID)
    public CandidateCardDto getCandidateCardById(@PathVariable("id") final Long id) {
        return candidateService.getCandidateCardById(id);
    }

}
