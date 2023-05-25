package hackathon.ru.data.service.user;


import hackathon.ru.data.dto.user.RoleDto;
import hackathon.ru.data.model.user.Role;
import hackathon.ru.data.service.user.iService.RoleService;
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
