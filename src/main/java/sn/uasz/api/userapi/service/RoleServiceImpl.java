package sn.uasz.api.userapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.api.userapi.mapper.RoleMapper;
import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.api.userapi.repository.RoleRepository;
import sn.uasz.spi.user.model.Role;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public void addRole(Role role) {
        System.out.println("input role: " + role.toString());
        RoleDto roleDto = roleMapper.mapToRoleDto(role);
        System.out.println("mapper roleDto: " + roleDto.toString());
        roleRepository.save(roleDto);
    }

    @Override
    public void deleteRole(Integer integer) {
        roleRepository.deleteById(Long.valueOf(integer));
    }

    @Override
    public List<Role> getAllRole() {
        List<RoleDto> all = (List<RoleDto>) roleRepository.findAll();
        return roleMapper.mapToRoleList(all);
    }
    @Override
    public RoleDto getRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public void update(Role role) {
        RoleDto roleDto = roleMapper.mapToRoleDto(role);
        roleRepository.save(roleDto);
    }
}
