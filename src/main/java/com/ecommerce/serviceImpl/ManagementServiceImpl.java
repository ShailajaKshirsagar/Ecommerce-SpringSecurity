package com.ecommerce.serviceImpl;

import com.ecommerce.entity.Management;
import com.ecommerce.repository.ManagementRepo;
import com.ecommerce.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementRepo managementRepo;

    @Override
    public String saveManager(Management management) {
        managementRepo.save(management);
        return "Manager Saved";
    }

    @Override
    public Management getById(int id) {

       Management management = managementRepo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        return management;
    }

    @Override
    public List<Management> getAllData() {
        List<Management> managementList = managementRepo.findAll();
        return managementList;
    }

    @Override
    public String deleteById(int id) {
        managementRepo.deleteById(id);
        return "Manager deleted";
    }

    @Override
    public Management updateManager(int id, Management management) {
        Management manager1 = managementRepo.findById(id).orElseThrow(() ->  new RuntimeException("Customer not found"));
        manager1.setCity(management.getCity());
        manager1.setName(management.getName());
        Management updatedManager = managementRepo.save(manager1);
        return updatedManager;
    }
}
