package sn.uasz.api.userapi.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sn.uasz.api.userapi.mapper.UserDtoMapper;
import sn.uasz.api.userapi.model.UserId;
import sn.uasz.api.userapi.repository.UserRepository;
import sn.uasz.api.userapi.mapper.UserMapper;
import sn.uasz.api.userapi.model.UserDto;
import sn.uasz.spi.user.model.User;


import javax.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDtoMapper userDtoMapper;


    @Override
    public void ajoutUser(@NotNull User user) {
        System.out.println("input user: " + user.toString());
        UserDto userDto = userMapper.mapToUserDto(user);
        System.out.println("mapper userDto: " + userDto.toString());
        userRepository.save(userDto);

        /*
        Iterable test1 = userRepository.findAll();
        Iterator<UserDto> tesResult = test1.iterator();
        UserDto result ;

        while(tesResult.hasNext()){
            result = tesResult.next();

            System.out.println("result: " + result.toString());
        }

        System.out.println("test1.iterator().hasNext(): " + test1.iterator().hasNext());
        */
    }

    public User getUserById(Integer userId) {
       System.out.println(userId);
        UserId userID = new UserId();
        userID.setEmail("d.sene2005@gmail.com");
        userID.setTelephone("779221682");
        UserDto userDto = userRepository.getUserById(userID);
        if (userDto==null){
            System.out.println("pas de user");
        }

        return userDtoMapper.mapToUser(userDto);

    }



}
