package hackathon.ru.controller.candidate;

import hackathon.ru.data.model.candidate.Degree;
import hackathon.ru.service.candidate.iservice.DegreeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Degree controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + DegreeController.DEGREE_CONTROLLER_PATH)
public class DegreeController {

    public static final String DEGREE_CONTROLLER_PATH = "/degrees";
    public static final String ID = "/{id}";
    private final DegreeService degreeService;


    @GetMapping(ID)
    public Degree getCandidateById(@PathVariable("id") final Long id) {
        return degreeService.getDegreeById(id);
    }


    @GetMapping()
    public List<Degree> getAllCandidates() {
        return degreeService.getAllDegrees();
    }

}
