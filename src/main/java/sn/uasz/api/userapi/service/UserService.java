package sn.uasz.api.userapi.service;


import sn.uasz.spi.user.model.User;

import java.util.List;


public interface UserService {

    void addUser(User user);
    User getUserById(Integer userId);
    void deleteUser(Integer integer);
    List<User> getAllUser();
    void updateUser(User user);
    void createUsersWithListInput(List<User> users);
    void createUsersWithArrayInput(List<User> users);
    String loginUser(String email, String pass);
    void logoutUser();



}
