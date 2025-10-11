package com.ecommerce.controller;

import com.ecommerce.dto.userUpdatePassword;
import com.ecommerce.entity.User;
import com.ecommerce.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody userUpdatePassword request, Authentication authentication){

        String loginuser = authentication.getName();

        if(!loginuser.equals(request.getUsername())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can set your password only");
        }

        customUserService.updatePassword(loginuser, request.getNewPassword());
        return new ResponseEntity<>("Password updated",HttpStatus.OK);
    }

    //update role
    @PutMapping("/update/role/{id}")
    public ResponseEntity<String> updateUserRole(@PathVariable("id") int id,@RequestBody User user){

        String msg = customUserService.updateUserRole(id,user);
        return new ResponseEntity<>(msg,HttpStatus.OK);

    }
}
