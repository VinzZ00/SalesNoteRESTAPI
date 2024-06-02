package com.elvin.salesBackEndApp.services.ShopService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.exception.RestException;
import com.elvin.salesBackEndApp.entity.Shop;
import com.elvin.salesBackEndApp.repository.ShopRepository;

@Service
public class GetShopService {
    
    @Autowired private ShopRepository shopRepository;
    @Autowired private ModelMapper modelMapper;
    
    // MARK: - Get All Shop
    public List<Shop> getAllShop() {
        return shopRepository
        .findAll()
        .stream()
        .map(s -> modelMapper.map(s, Shop.class))
        .collect(Collectors.toList());
    }


    // MARK: - Get Shop By Phone Number
    public Shop getShopByPhoneNumber(String phoneNumber) {

        Optional<Shop> shop = shopRepository.findOneByPhoneNumber(phoneNumber);

        if (!shop.isPresent()) {
            throw RestException.shopNotFound();
        }

        return modelMapper.map(shop.get(), Shop.class);
    }

    // MARK: - Get Shop By Id
    public Shop getShopById(String id) {
        Optional<Shop> shop = shopRepository.findById(UUID.fromString(id));

        if (!shop.isPresent()) {
            throw RestException.shopNotFound();
        }

        return modelMapper.map(shop.get(), Shop.class);
    }
}
