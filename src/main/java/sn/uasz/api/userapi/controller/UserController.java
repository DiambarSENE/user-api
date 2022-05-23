package sn.uasz.api.userapi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import sn.uasz.api.userapi.service.UserServiceImpl;
import sn.uasz.spi.user.UserApi;
import sn.uasz.spi.user.model.User;

@Validated
@Slf4j
@RestController
public class UserController implements UserApi {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(value = "/user")
    @Override
    public ResponseEntity<Void> ajoutUser(User user) {
        log.info("creation d'un nouveau utilisateur");
        userServiceImpl.ajoutUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Void> connexionUser(@NotNull @Valid String s, @NotNull @Valid String s1) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createUsersWithArrayInput(@Valid User user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createUsersWithListInput(@Valid User user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deconnexionUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAllUser() {
        return null;
    }

    @GetMapping(value = "/user/{userId}")
    @Override
    public ResponseEntity<User> getUserById(Integer integer) {
        log.info("Recuperer un  utilisateur par son id");
        userServiceImpl.getUserById(integer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateUser(@Min(1L) Integer integer, @Valid User user) {
        return null;
    }


    /*
     * private <T> ResponseEntity<T> responseEntityHandler(T body, String
     * reasonPhrase, HttpStatus status) {
     *
     * URI location = URI.create("yatout-user-uri");
     * HttpHeaders responseHeaders = new HttpHeaders();
     * responseHeaders.setLocation(location);
     * responseHeaders.set("reasonPhrase", reasonPhrase);
     * responseHeaders.setContentType(MediaType.APPLICATION_JSON);
     *
     * return new ResponseEntity<>(body, responseHeaders, status);
     * }
     */


}
