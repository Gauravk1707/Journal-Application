package com.myProject.controller;

import com.myProject.entity.UserEntity;
import com.myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class publicController {

    @Autowired
    public UserService userService;
    @GetMapping("/health-check")
    public String health_check(){
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody UserEntity userEntity){
        userService.saveEntry(userEntity);
    }
}
