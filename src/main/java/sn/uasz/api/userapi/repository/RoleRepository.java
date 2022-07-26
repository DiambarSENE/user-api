package sn.uasz.api.userapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.api.userapi.model.RoleDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RoleDto, Long> {

    //@Query(value = "SELECT r FROM RoleDto r WHERE r.name = ?1")
    @Query(value = "SELECT * FROM roles r WHERE r.name = ?1",nativeQuery = true)
    RoleDto findByName(String roles);






}
