package sn.uasz.api.userapi.mapper.generated;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sn.uasz.api.userapi.mapper.RoleMapper;
import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.spi.user.model.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T17:22:58+0200"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto mapToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.roleName = role.getRoleName();
        roleDto.roleDescription = role.getRoleDescription();

        return roleDto;
    }

    @Override
    public Role mapToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleName( roleDto.roleName );
        role.setRoleDescription( roleDto.roleDescription );

        return role;
    }

    @Override
    public List<Role> mapToRoleList(List<RoleDto> all) {
        if ( all == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( all.size() );
        for ( RoleDto roleDto : all ) {
            list.add( mapToRole( roleDto ) );
        }

        return list;
    }

    @Override
    public List<RoleDto> mapToRoleListDto(List<Role> all) {
        if ( all == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( all.size() );
        for ( Role role : all ) {
            list.add( mapToRoleDto( role ) );
        }

        return list;
    }
}
