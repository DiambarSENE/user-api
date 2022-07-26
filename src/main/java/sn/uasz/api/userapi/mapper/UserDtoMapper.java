package sn.uasz.api.userapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface UserDtoMapper {

   /*
   @Mapping(target = "matricule", source = "userId.matricule")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "departement", source = "departement")
    @Mapping(target = "roles", source = "roles")
    User mapToUser(UserDto userDto);

    List<User> mapToUserList(List<Object> userDto);
    */




}
