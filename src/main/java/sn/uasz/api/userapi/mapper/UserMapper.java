package sn.uasz.api.userapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;



@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId.telephone", source = "telephone")
    @Mapping(target = "userId.email", source = "email")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "matricule", source = "matricule")
    @Mapping(target = "departement", source = "departement")
    @Mapping(target = "roles", source = "roles")
    UserDto mapToUserDto(User user);





}
