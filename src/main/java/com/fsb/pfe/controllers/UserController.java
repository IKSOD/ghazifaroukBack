package com.fsb.pfe.controllers;


import com.fsb.pfe.dto.UserDto;
import com.fsb.pfe.entities.User;
import com.fsb.pfe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="user")
@CrossOrigin(value = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody()UserDto userDto)
    {
        return  this.userService.addUser(userDto);
    }

    @PostMapping(value = "/getUser")
    public UserDto getUser(@RequestBody()UserDto userDto)
    {
        return  this.userService.getUserByCode(userDto);
    }
}
