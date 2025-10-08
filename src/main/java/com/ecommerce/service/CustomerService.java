package com.ecommerce.service;

import com.ecommerce.entity.Customer;

import java.util.List;

public interface CustomerService {
    String saveCustomer(Customer customer);

    Customer getcustomerbyid(int id);

    List<Customer> getAllCustomer();

    String deletecustomer(int id);

    Customer updateCustomer(int id, Customer customer);
}
