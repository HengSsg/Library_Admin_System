package com.library.admin.controller;

import com.library.admin.mapper.UserMapper;
import com.library.admin.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDTO userDTO) {
        userMapper.save(userDTO);
    }
}
