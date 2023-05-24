package hackathon.ru.service;


import hackathon.ru.dto.user.RoleDto;
import hackathon.ru.model.user.Role;
import hackathon.ru.service.iService.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {


    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
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
