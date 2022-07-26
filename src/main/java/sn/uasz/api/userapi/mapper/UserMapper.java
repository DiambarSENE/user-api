package sn.uasz.api.userapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

import java.util.List;


@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    /*
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "matricule", source = "matricule")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "ufr", source = "ufr")
    @Mapping(target = "departement", source = "departement")
    @Mapping(target = "roles", source = "userRole")
     */


   UserDto mapToUserDto(User user);
   User mapToUser(UserDto userDto);
   List<UserDto> mapToUserDtoList(List<User> user);
   List<User> mapToUserList(List<UserDto> userDto);




}
