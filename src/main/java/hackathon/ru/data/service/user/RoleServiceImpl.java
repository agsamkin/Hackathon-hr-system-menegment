package hackathon.ru.data.service.user;


import hackathon.ru.data.dto.user.RoleDto;
import hackathon.ru.data.model.user.Role;
import hackathon.ru.data.repository.RoleRepository;
import hackathon.ru.data.service.user.iService.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("role with that id is not found"));
    }

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<>(roleRepository.findAll());
    }

    @Override
    public Role createRole(RoleDto roleDto) {
        return null;
    }

    @Override
    public Role updateRole(Long id, RoleDto roleDto) {
        return null;
    }

    @Override
    public void deleteRoleById(Long id) {

    }
}
