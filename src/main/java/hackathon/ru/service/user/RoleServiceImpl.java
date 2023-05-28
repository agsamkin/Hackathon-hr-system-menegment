package hackathon.ru.service.user;


import hackathon.ru.data.dto.user.RoleDto;
import hackathon.ru.data.model.user.Role;
import hackathon.ru.data.repository.RoleRepository;
import hackathon.ru.service.user.iService.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("role with that id is not found"));
    }

    @Override
    @Transactional(readOnly = true)
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
