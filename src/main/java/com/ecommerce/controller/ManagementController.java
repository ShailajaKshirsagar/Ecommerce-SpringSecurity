package com.ecommerce.controller;

import com.ecommerce.entity.Management;
import com.ecommerce.service.ManagementService;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //ad managemnt
    @PostMapping("/addManager")
    public ResponseEntity<String> addManager(@RequestBody Management management){
        String msg = managementService.saveManager(management);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    //get by id
    @GetMapping("/getManagerById/{id}")
    public ResponseEntity<Management> getManagerById(@PathVariable ("id") int id){
       Management manager = managementService.getById(id);
       return  new ResponseEntity<>(manager,HttpStatus.OK);
    }

    //get all data
    @GetMapping("/getAllData")
    public ResponseEntity<List<Management>> getAllData(){
        List<Management> managementList = managementService.getAllData();
        return new ResponseEntity<>(managementList,HttpStatus.OK);
    }

    //delete data
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") int id){
        String msg = managementService.deleteById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    //update
    @PutMapping("/updateManager/{id}")
    public ResponseEntity<Management> updateCustomer(@PathVariable("id") int id,@RequestBody Management management){
        Management updatedManager = managementService.updateManager(id,management);
        return new ResponseEntity<>(updatedManager,HttpStatus.OK);
    }

}

