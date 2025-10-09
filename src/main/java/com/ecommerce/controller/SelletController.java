package com.ecommerce.controller;

import com.ecommerce.entity.Seller;
import com.ecommerce.service.SellerService;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //add seller
    @PostMapping("/addSeller")
    public ResponseEntity<String> addSeller(@RequestBody Seller seller){
        String msg = sellerService.saveSeller(seller);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    //get by id
    @GetMapping("/getSellerById/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") long id){
        Seller sellerById = sellerService.getSellerById(id);
        return new ResponseEntity<>(sellerById,HttpStatus.OK);
    }

    //get all seller
    @GetMapping("/getAllSeller")
    public  ResponseEntity<List<Seller>> getAllSeller(){
        List<Seller> sellerList = sellerService.getAllSeller();
        return new ResponseEntity<>(sellerList,HttpStatus.OK);
    }

    //delete seller
    @DeleteMapping("/deleteSeller")
    public ResponseEntity<String> deleteSeller(@PathVariable("id") long id){
        String msg = sellerService.deleteSeller(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    //update seller
    public ResponseEntity<Seller> updateSeller(@PathVariable("id") long id,@RequestBody Seller seller){
        Seller updatedseller = sellerService.updateSeller( id,seller);
        return new ResponseEntity<>(updatedseller,HttpStatus.OK);
    }

}
