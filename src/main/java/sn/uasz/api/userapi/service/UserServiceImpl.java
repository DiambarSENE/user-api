package sn.uasz.api.userapi.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.uasz.api.userapi.exception.ImpossibleAddUserException;
import sn.uasz.api.userapi.exception.UserNotFoundException;
import sn.uasz.api.userapi.model.RoleDto;
import sn.uasz.api.userapi.repository.RoleRepository;
import sn.uasz.api.userapi.repository.UserRepository;
import sn.uasz.api.userapi.mapper.UserMapper;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;
    //@Autowired
    //private RoleMapper roleMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void addUser(User user) throws ImpossibleAddUserException{
        //System.out.println("input user: " + user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDto userDto = userMapper.mapToUserDto(user);
        RoleDto roleUser = roleRepository.findByName(user.getUserRole());
        if(!roleUser.getRoleName().isEmpty()){
            userDto.addRole(roleUser);
            userRepository.save(userDto);
        }else {
            throw new ImpossibleAddUserException("impossible d'ajouter l'utilisateur");
        }

        Iterable test1 = userRepository.findAll();
        Iterator<UserDto> tesResult = test1.iterator();
        UserDto result ;

        while(tesResult.hasNext()){
            result = tesResult.next();
            System.out.println("result: " + result.toString());
        }

        System.out.println("test1.iterator().hasNext(): " + test1.iterator().hasNext());

    }
    public User getUserById(Integer userId) throws UserNotFoundException{
       System.out.println(userId);
       UserDto userDto = userRepository.findByUserId(Long.valueOf(userId));
       if(userDto==null)
           throw new UserNotFoundException("Le User correspondant à l'id " + userId + " n'existe pas");
       return userMapper.mapToUser(userDto);

    }
    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(Long.valueOf(userId));
        System.out.println("delete user by id: " + userId);
    }
    @Override
    public List<User> getAllUser() throws UserNotFoundException{
        Iterable listUser  =  userRepository.findAll();
        System.out.println("result: " + listUser);
        if(listUser == null)
          throw new UserNotFoundException("Aucun user n'est disponible");
        return userMapper.mapToUserList((List<UserDto>) listUser);

    /*    Iterable test1 = userRepository.findAll();
        Iterator<UserDto> tesResult = test1.iterator();
        List<UserDto> r = new ArrayList<>();
        while(tesResult.hasNext()){
            r.add(tesResult.next());
            System.out.println("result: " + r);
        }
        return userMapper.mapToUserList(r);
        System.out.println("test1.iterator().hasNext(): " + test1.iterator().hasNext());
     */
    }
    @Override
    public void createUsersWithListInput(List<User> user) {
        for (User str : user) {
            str.setPassword(passwordEncoder.encode(str.getPassword()));
            UserDto userDto = userMapper.mapToUserDto(str);
            RoleDto roleUser = roleRepository.findByName(str.getUserRole());
            userDto.addRole(roleUser);
            userRepository.save(userDto);
        }


    }
    @Override
    public void createUsersWithArrayInput(List<User> listUser) {
        for (User str : listUser) {
            str.setPassword(passwordEncoder.encode(str.getPassword()));
            UserDto userDto = userMapper.mapToUserDto(str);
            RoleDto roleUser = roleRepository.findByName(str.getUserRole());
            userDto.addRole(roleUser);
            userRepository.save(userDto);
        }
        //System.out.println("mapper userDto: " + list.toString());
        //List<UserDto> userDto = userMapper.mapToUserDtoList(list);
        //System.out.println("mapper userDto: " + userDto.toString());
        //userRepository.saveAll(userDto);
        //return null;
    }

    @Override
    public String loginUser(String email, String pass )  {
        UserDto existingUser = userRepository.findByEmail(email);
        if(passwordEncoder.matches(pass,existingUser.getPassword())  && existingUser.getEmail().equals(email)){
            return "login ok";
        }else{
            return "email ou password n'est pas valide";
        }
    }

    @Override
    public void logoutUser() {

    }

    @Override
    public void updateUser(User user) {
        UserDto userDto = userMapper.mapToUserDto(user);
        userRepository.save(userDto);

    }


}
