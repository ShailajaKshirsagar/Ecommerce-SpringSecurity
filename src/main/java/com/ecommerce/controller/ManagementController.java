package com.ecommerce.controller;

import com.ecommerce.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @GetMapping("/something")
    public ResponseEntity<String> getSomething(){
        String msg = "In Management Controller";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    
}

