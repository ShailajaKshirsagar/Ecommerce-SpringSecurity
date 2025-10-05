package com.ecommerce.repository;

import com.ecommerce.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepo extends JpaRepository<Management,Integer> {
}
