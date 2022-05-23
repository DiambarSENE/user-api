package sn.uasz.api.userapi.service;


import org.springframework.validation.annotation.Validated;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

@Validated
public interface UserService {
     //void getAllUser();

    void ajoutUser(User user);
    User getUserById(Integer userId);
}
