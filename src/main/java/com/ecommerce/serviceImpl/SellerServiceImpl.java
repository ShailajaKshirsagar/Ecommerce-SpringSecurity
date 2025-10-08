package com.ecommerce.serviceImpl;

import com.ecommerce.entity.Seller;
import com.ecommerce.repository.SellerRepo;
import com.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepo sellerRepo;

    @Override
    public String saveSeller(Seller seller) {
        sellerRepo.save(seller);
        return "Seller saved";
    }

    @Override
    public Seller getSellerById(long id) {
        Seller sellerbyid = sellerRepo.findById(id).orElseThrow(()-> new RuntimeException("Seller not found"));
        return sellerbyid;
    }

    @Override
    public List<Seller> getAllSeller() {
        List<Seller> sellerList = sellerRepo.findAll();
        return sellerList;
    }

    @Override
    public String deleteSeller(long id) {
        sellerRepo.deleteById(id);
        return "Seller deleted";
    }

    @Override
    public Seller updateSeller(long id, Seller seller) {
        Seller seller1 = sellerRepo.findById(id).orElseThrow(()->new RuntimeException("Seller not found"));

        seller1.setName(seller.getName());
        seller1.setCity(seller.getCity());

        Seller updatedSeller = sellerRepo.save(seller1);

        return updatedSeller;
    }
}
