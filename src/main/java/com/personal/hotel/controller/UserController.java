package com.personal.hotel.controller;

import com.personal.hotel.dto.UserDTO;
import com.personal.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

}
