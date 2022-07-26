package sn.uasz.api.userapi.mapper.generated;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sn.uasz.api.userapi.mapper.UserMapper;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T17:22:57+0200"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.userId = user.getUserId();
        userDto.nom = user.getNom();
        userDto.prenom = user.getPrenom();
        userDto.email = user.getEmail();
        userDto.matricule = user.getMatricule();
        userDto.telephone = user.getTelephone();
        userDto.password = user.getPassword();
        userDto.ufr = user.getUfr();
        userDto.departement = user.getDepartement();

        return userDto;
    }

    @Override
    public User mapToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.userId );
        user.setNom( userDto.nom );
        user.setPrenom( userDto.prenom );
        user.setEmail( userDto.email );
        user.setPassword( userDto.password );
        user.setTelephone( userDto.telephone );
        user.setMatricule( userDto.matricule );
        user.setUfr( userDto.ufr );
        user.setDepartement( userDto.departement );

        return user;
    }

    @Override
    public List<UserDto> mapToUserDtoList(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( user.size() );
        for ( User user1 : user ) {
            list.add( mapToUserDto( user1 ) );
        }

        return list;
    }

    @Override
    public List<User> mapToUserList(List<UserDto> userDto) {
        if ( userDto == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDto.size() );
        for ( UserDto userDto1 : userDto ) {
            list.add( mapToUser( userDto1 ) );
        }

        return list;
    }
}
