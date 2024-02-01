package com.personal.hotel.service;

import com.personal.hotel.dto.UserDTO;
import com.personal.hotel.mapper.UserMapper;
import com.personal.hotel.model.User;
import com.personal.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public void createUser(UserDTO userDto){
        User user = userMapper.convertUserDtoToEntity(userDto);
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            userDtoList.add(userMapper.convertUserEntityToDto(user));
        });
        return userDtoList;
    }

}
