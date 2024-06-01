package com.elvin.salesBackEndApp.services.ShopService;

import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.exception.RestException;
import com.elvin.salesBackEndApp.dto.shop.AddAndUpdateShopDTO;
import com.elvin.salesBackEndApp.entity.Shop;
import com.elvin.salesBackEndApp.repository.ShopRepository;

import jakarta.validation.ConstraintViolationException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class UpdateShopService {
    
    @Autowired private ShopRepository shopRepository;
    @Autowired private Validator validator;
    @Autowired private ModelMapper modelMapper;
    
    @Transactional
    public Shop updateShop(AddAndUpdateShopDTO updateShopDto) {
        Set<ConstraintViolation<AddAndUpdateShopDTO>> violations = validator.validate(updateShopDto);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);
        
        Optional<Shop> shop = shopRepository.findOneByPhoneNumber(updateShopDto.getPhoneNumber());
        if (!shop.isPresent()) throw RestException.shopNotFound();

        Shop shopEntity = shop.get();
        
        shopEntity.setName(updateShopDto.getName());
        shopEntity.setAddress(updateShopDto.getAddress());
        shopRepository.save(shopEntity);
        
        return modelMapper.map(shopEntity, Shop.class);
    } 
}
