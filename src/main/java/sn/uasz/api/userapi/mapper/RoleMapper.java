package sn.uasz.api.userapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.spi.user.model.Role;

import java.util.List;


@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface RoleMapper {

    @Mapping(target = "roleName", source = "roleName" )
    @Mapping(target = "roleDescription", source = "roleDescription")

    RoleDto mapToRoleDto(Role role);
    Role mapToRole(RoleDto roleDto);
    List<Role> mapToRoleList(List<RoleDto> all);
    List<RoleDto> mapToRoleListDto(List<Role> all);
}
