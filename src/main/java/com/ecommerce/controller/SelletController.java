package com.ecommerce.controller;

import com.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SelletController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/something")
    public ResponseEntity<String> getSomething(){
        String msg = "In Seller Controller";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
