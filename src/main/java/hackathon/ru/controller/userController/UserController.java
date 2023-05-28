package hackathon.ru.controller.userController;


import hackathon.ru.data.dto.user.UserDto;
import hackathon.ru.data.model.user.User;
import hackathon.ru.service.user.iService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + UserController.USER_CONTROLLER_PATH)
public class UserController {
    public static final String USER_CONTROLLER_PATH = "/users";

    public static final String ID = "/{id}";

    private static final String ONLY_OWNER_BY_ID = """
                @userRepository.findById(#id).get().getEmail() == authentication.getName()
            """;

    private final UserService userService;

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping(ID)
    public User getUserById(@PathVariable("id") final long id) {
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @PostMapping("/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @PostMapping()
    public User createUser(@RequestBody @Valid UserDto userDTO) {
        return userService.createUser(userDTO);
    }

    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @PutMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public User updateUser(@PathVariable("id") final long id,
                           @RequestBody @Valid final UserDto userDTO) {
        return userService.updateUser(id, userDTO);
    }


    @DeleteMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void deleteUser(@PathVariable("id") final long id) {
        userService.deleteUserById(id);
    }

}
