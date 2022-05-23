package sn.uasz.api.userapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.api.userapi.model.UserId;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {
    UserDto getUserById(UserId userID);

}
