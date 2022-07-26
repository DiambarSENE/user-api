package sn.uasz.api.userapi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import sn.uasz.api.userapi.service.RoleService;
import sn.uasz.api.userapi.service.UserService;
import sn.uasz.spi.user.UserApi;
import sn.uasz.spi.user.model.Role;
import sn.uasz.spi.user.model.User;

@Validated
@Slf4j
@RestController
public class UserController implements UserApi {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    //@Autowired
    //private AuthenticationManager authenticationManager;
    @PostMapping("/addUser")
    @Override
    public ResponseEntity<Void> addUser(@Valid User user) {
        log.info("creation d'un nouveau utilisateur");
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    @Override
    public ResponseEntity<String> loginUser(@NotNull @Valid String s, @NotNull @Valid String s1) {
        String userId = userService.loginUser(s,s1);
        System.out.println("userId " + userId);
        return new ResponseEntity<>(userId,HttpStatus.OK);

        //Authentication authObject = null;
        //try {
          //  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
           // SecurityContextHolder.getContext().setAuthentication(authObject);
       // } catch (BadCredentialsException e) {
         //   System.out.println("Invalid credentials");
       // }

        //return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/arrayInput")
    @Override
    public ResponseEntity<Void> createUsersWithArrayInput(@Valid List<User> list) {
        log.info("creation des nouveau utilisateurs avec array");
        userService.createUsersWithArrayInput(list);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/listInput")
    @Override
    public ResponseEntity<Void> createUsersWithListInput(@Valid List<User> list) {
        log.info("creation des nouveaux utilisateurs avec list");
        userService.createUsersWithListInput(list);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Override
    public ResponseEntity<Void> logoutUser() {
        userService.logoutUser();
        return null;
    }
    @DeleteMapping("/deleteUser/{integer}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Integer integer) {
        log.info("supprimer un utilisateur avec son id");
        userService.deleteUser(integer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/users/getAllUser")
    @Override
    public ResponseEntity<List<User>> getAllUser() {
        log.info("retourne une liste de users");
        List<User> l =  userService.getAllUser();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
    @GetMapping("/users/{integer}")
    @Override
    public ResponseEntity<User> getUserById(@PathVariable Integer integer) {
        log.info("Recuperer un  utilisateur par son id");
        User l = userService.getUserById(integer);
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @PutMapping("/updateUser/{integer}")
    @Override
    public ResponseEntity<Void> updateUser(@PathVariable Integer integer, @RequestBody User user) {
        log.info("modifier un utilisateur");
        user.setUserId(Long.valueOf(integer));
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/role/createRole")
    @Override
    public ResponseEntity<Void> createRole(@Valid Role role) {
        log.info("creation d'un nouveau role");
        roleService.addRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/role/delete/{integer}")
    @Override
    public ResponseEntity<Void> deleteRole(@PathVariable Integer integer) {
        roleService.deleteRole(integer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/role/listeRole")
    @Override
    public ResponseEntity<List<Role>> getAllRole() {
        log.info("retourne une liste de role");
        List<Role> l =  roleService.getAllRole();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }
    @GetMapping("/roleName/{nom}")
    @Override
    public ResponseEntity<Role> getRoleByName(@PathVariable String nom) {
        roleService.getRoleByName(nom);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/roles/{s}")
    @Override
    public ResponseEntity<Void> updateRole(@PathVariable String s, @Valid Role role) {
        role.setRoleName(s);
        roleService.update(role);
        return new ResponseEntity<>(HttpStatus.OK);
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
