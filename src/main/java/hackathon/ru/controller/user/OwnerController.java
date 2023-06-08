package hackathon.ru.controller.user;

import hackathon.ru.data.dto.user.customDto.OwnerDto;
import hackathon.ru.service.user.iService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Owner Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + OwnerController.OWNER_CONTROLLER_PATH)
public class OwnerController {
    public static final  String OWNER_CONTROLLER_PATH = "/owners";
    public static final  String ID = "/{id}";

    private final UserService userService;


    @Operation(summary = "Get all Owners")
    @ApiResponse(responseCode = "200", description = "Owners was successfully found")
    @GetMapping()
    public List<OwnerDto> getAllOwners() {
        return userService.getOwners();
    }

}
