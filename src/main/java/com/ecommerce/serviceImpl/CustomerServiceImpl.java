package com.ecommerce.serviceImpl;

import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepo;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired

    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(Customer customer) {
        customerRepo.save(customer);
        return "Customer saved";
    }

    @Override
    public Customer getcustomerbyid(int id) {
        Customer customer = customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer not found with id: " + id));
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = customerRepo.findAll();
        return customerList;
    }

    @Override
    public String deletecustomer(int id) {
        customerRepo.deleteById(id);
        return "Customer deleted";
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow(() ->  new RuntimeException("Customer not found"));

        customer1.setFname(customer.getFname());
        customer1.setLname(customer.getLname());
        customer1.setMobileno(customer.getMobileno());

        Customer updatedCustomer = customerRepo.save(customer1);
        return updatedCustomer;
    }
}
