package com.ecommerce.service;

import com.ecommerce.entity.Management;

import java.util.List;

public interface ManagementService {
    String saveManager(Management management);

    Management getById(int id);

    List<Management> getAllData();

    String deleteById(int id);

    Management updateManager(int id, Management management);
}
