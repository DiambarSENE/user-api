package sn.uasz.api.userapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {
    UserDto findByUserId(Long userId);

    UserDto findByEmail(String email);

    // @Query("SELECT * FROM Users u LEFT JOIN u.roles role WHERE role.id = ?1")
    // List<User> findUserByRole(int role);




}
