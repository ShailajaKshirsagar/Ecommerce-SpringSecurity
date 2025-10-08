package com.ecommerce.controller;

import com.ecommerce.entity.User;
import com.ecommerce.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomUserService customUserService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
       String msg = customUserService.saveUser(user);
       return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
