package hackathon.ru.controller.userController;

import hackathon.ru.data.dto.user.customDto.OwnerDto;
import hackathon.ru.service.user.iService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + OwnerController.OWNER_CONTROLLER_PATH)
public class OwnerController {
    public final static String OWNER_CONTROLLER_PATH = "/owners";
    public final static String ID = "/{id}";

    private final UserService userService;

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping()
    public List<OwnerDto> getAllOwners() {
        return userService.getOwners();
    }






}
