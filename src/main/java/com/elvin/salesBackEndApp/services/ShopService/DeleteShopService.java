package com.elvin.salesBackEndApp.services.ShopService;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.entity.Shop;
import com.elvin.salesBackEndApp.repository.ShopRepository;

@Service
public class DeleteShopService {

    @Autowired private ShopRepository shopRepository;

    public String deleteShop(String id) {
        Optional<Shop> shopOptional = shopRepository.findById(UUID.fromString(id));
        if (shopOptional.isPresent()) {
            try {
                shopRepository.deleteById(UUID.fromString(id));
                return "Data deleted";
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
                return "Error occured : " + e.getMessage();
            }
        } else {
            return "No Shop data found with this id";
        }
       
    }
}
