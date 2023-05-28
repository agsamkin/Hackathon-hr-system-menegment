package hackathon.ru.service.user.iService;


import hackathon.ru.data.dto.user.UserDto;
import hackathon.ru.data.dto.user.customDto.OwnerDto;
import hackathon.ru.data.model.user.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUsers();

    List<OwnerDto> getOwners();

    User createUser(UserDto userDTO);

    User updateUser(Long id, UserDto userDTO);

    void deleteUserById(Long id);

    String getCurrentUserName();

    User getCurrentUser();
}

