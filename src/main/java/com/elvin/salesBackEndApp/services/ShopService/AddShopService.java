package com.elvin.salesBackEndApp.services.ShopService;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.Exception.RestException;
import com.elvin.salesBackEndApp.dto.shop.AddAndUpdateShopDTO;
import com.elvin.salesBackEndApp.entity.Shop;
import com.elvin.salesBackEndApp.repository.ShopRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;


@Service
public class AddShopService {
    
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Shop addingShop(AddAndUpdateShopDTO addShopDto) {
        Set<ConstraintViolation<AddAndUpdateShopDTO>> violations = validator.validate(addShopDto);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (!shopRepository.existsByPhoneNumber(addShopDto.getPhoneNumber())) {
            throw RestException.shopAlreadyRegistered();
        }

        return shopRepository.save(modelMapper.map(addShopDto, Shop.class));
    }

    
}
