package com.ecommerce.controller;

import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/something")
    public ResponseEntity<String> getSomething(){
        String msg = "In Customer Controller";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //add customer api
    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        String msg = customerService.saveCustomer(customer);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    //get by id
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getcustomerbyid(@PathVariable("id") int id){
        Customer customerById = customerService.getcustomerbyid(id);
        return new ResponseEntity<>(customerById,HttpStatus.OK);
    }

    //get all customer
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    //Delete customer
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        String msg = customerService.deletecustomer(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    //update api
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
    }

}
