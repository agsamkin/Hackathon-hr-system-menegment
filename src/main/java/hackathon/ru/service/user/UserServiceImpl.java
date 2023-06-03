package hackathon.ru.service.user;


import hackathon.ru.config.security.SecurityConfig;
import hackathon.ru.data.dto.user.UserDto;
import hackathon.ru.data.dto.user.customDto.OwnerDto;
import hackathon.ru.data.model.user.User;
import hackathon.ru.data.repository.UserRepository;
import hackathon.ru.service.cityService.CityService;
import hackathon.ru.service.user.iService.RoleService;
import hackathon.ru.service.user.iService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final CityService cityService;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким id не найден"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OwnerDto> getOwners() {
        List<User> users = userRepository.findUsersByRoleName("Заказчик");

        if (users.isEmpty()) {
            return new ArrayList<>();
        }

        List<OwnerDto> owners = new ArrayList<>();
        for (User user: users) {
            OwnerDto ownerDto = OwnerDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .build();
            owners.add(ownerDto);
        }
        return owners;
    }


    @Override
    public User createUser(UserDto userDTO) {
        User user = User.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phone(userDTO.getPhone())
                .city(cityService.getCityById(userDTO.getCityId()))
                .role(roleService.getRoleById(userDTO.getRoleId()))
                .build();

        System.out.println(user.getFirstName());

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto userDTO) {
        User user = getUserById(id);
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user with that id is not found"));
        userRepository.delete(user);
    }

    @Override
    public String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findUserByEmail(getCurrentUserName())
                .orElseThrow(() -> new UsernameNotFoundException("user with that username is not found"));
    }
//    public User getCurrentUser() {
//        return ((User) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal());
//    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .map(this::buildSpringUser)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user with 'email': " + email));

    }

    private UserDetails buildSpringUser(final User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                SecurityConfig.DEFAULT_AUTHORITIES
        );
    }
}
