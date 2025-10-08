package com.ecommerce.service;

import com.ecommerce.entity.Seller;

import java.util.List;

public interface SellerService {
    String saveSeller(Seller seller);

    Seller getSellerById(long id);

    List<Seller> getAllSeller();

    String deleteSeller(long id);

    Seller updateSeller(long id, Seller seller);
}
