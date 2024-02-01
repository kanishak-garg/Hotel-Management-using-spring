package com.personal.hotel.mapper;

import com.personal.hotel.dto.UserDTO;
import com.personal.hotel.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertUserDtoToEntity(UserDTO userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDTO convertUserEntityToDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
