package hackathon.ru.controller.candidate;

import hackathon.ru.data.dto.candidate.CandidateDto;
import hackathon.ru.data.dto.candidate.outputDto.CandidateCardDto;
import hackathon.ru.data.dto.candidate.outputDto.CandidateForListDto;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.service.candidate.iservice.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Candidate controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + CandidateController.CANDIDATE_CONTROLLER_PATH)
public class CandidateController {

    public static final String CANDIDATE_CONTROLLER_PATH = "/candidates";
    public static final String ID = "/{id}";

    private final CandidateService candidateService;

    @Operation(summary = "Create new Candidate")
    @ApiResponse(responseCode = "201", description = "Candidate was successfully created")
    @PostMapping()
    @ResponseStatus(CREATED)
    public Candidate createCandidate(
        @Parameter(schema = @Schema(implementation = CandidateDto.class))
        @RequestBody @Valid CandidateDto candidateDto) {
        return candidateService.createNewCandidate(candidateDto);
    }



    // PUT /api/candidates/{id} - обновление кандидата
    @Operation(summary = "Candidate User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "Candidate with that id does not exist")
    })
    @PutMapping(ID)
    public Candidate updateCandidate(@PathVariable("id") final Long id,
                                     @RequestBody @Valid final CandidateDto candidateDto) {
        return candidateService.updateCandidate(id, candidateDto);
    }


    // DELETE /api/candidates/{id} - удаление кандидата
    @Operation(summary = "Delete Candidate by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate with that id was successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Candidate with that id does not exist")
    })
    @DeleteMapping(ID)
    public void deleteCandidate(@PathVariable("id") final Long id) {
        candidateService.deleteCandidate(id);
    }



    //-----------DTO-----------//


    // GET /api/candidates/hr - получение списка кандидатов
    @Operation(summary = "Get All Candidates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidates was successfully found"),
    })
    @GetMapping()
    public List<CandidateForListDto> getAllCandidatesList() {
        return candidateService.getListOfCandidates();
    }


    // GET /api/candidates/{id} - получение кандидата по идентификатору

    @Operation(summary = "Get Candidate Card by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "User with that id does not exist")
    })
    @GetMapping(ID)
    public CandidateCardDto getCandidateCardById(@PathVariable("id") final Long id) {
        return candidateService.getCandidateCardById(id);
    }

}
