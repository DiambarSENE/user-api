package sn.uasz.api.userapi.service;

import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.spi.user.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    void deleteRole(Integer integer);
    List<Role> getAllRole();
    RoleDto getRoleByName(String roleName);

    void update(Role rol);
}
