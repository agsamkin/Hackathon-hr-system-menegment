package hackathon.ru.controller.userController;


import hackathon.ru.data.dto.user.UserDto;
import hackathon.ru.data.model.user.User;
import hackathon.ru.service.user.iService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "User Controller")
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

    @Operation(summary = "Get User by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with that id was successfully found"),
            @ApiResponse(responseCode = "404", description = "User with that id does not exist")
    })
    @GetMapping(ID)
    public User getUserById(@PathVariable("id") final long id) {
        return userService.getUserById(id);
    }


    @Operation(summary = "Get all Users")
    @ApiResponse(responseCode = "200", description = "Users was successfully found")
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get current User")
    @ApiResponse(responseCode = "200", description = "User was successfully found")
    @PostMapping("/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @Operation(summary = "Create new User")
    @ApiResponse(responseCode = "201", description = "User was successfully created")
    @ResponseStatus(CREATED)
    @PostMapping()
    public User createUser(@RequestBody @Valid UserDto userDTO) {
        return userService.createUser(userDTO);
    }


    @Operation(summary = "Update User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with that id was successfully updated"),
            @ApiResponse(responseCode = "404", description = "User with that id does not exist")
    })
    @PutMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public User updateUser(@PathVariable("id") final long id,
                           @RequestBody @Valid final UserDto userDTO) {
        return userService.updateUser(id, userDTO);
    }


    @Operation(summary = "Delete User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with that id was successfully deleted"),
            @ApiResponse(responseCode = "404", description = "User with that id does not exist")
    })
    @DeleteMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void deleteUser(@PathVariable("id") final long id) {
        userService.deleteUserById(id);
    }

}
