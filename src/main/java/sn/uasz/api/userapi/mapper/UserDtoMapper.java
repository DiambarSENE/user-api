package sn.uasz.api.userapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;
@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface UserDtoMapper {

    @Mapping(target = "telephone", source = "userId.telephone")
    @Mapping(target = "email", source = "userId.email")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "matricule", source = "matricule")
    @Mapping(target = "departement", source = "departement")
    @Mapping(target = "roles", source = "roles")
    User mapToUser(UserDto userDto);



}
