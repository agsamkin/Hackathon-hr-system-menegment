package hackathon.ru.service.iService;


import hackathon.ru.dto.user.UserDto;
import hackathon.ru.model.user.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUsers();

    User createUser(UserDto userDTO);

    User updateUser(Long id, UserDto userDTO);

    void deleteUserById(Long id);

    String getCurrentUserName();

    User getCurrentUser();
}

