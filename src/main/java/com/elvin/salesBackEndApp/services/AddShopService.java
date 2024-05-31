package com.elvin.salesBackEndApp.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.Exception.RestException;
import com.elvin.salesBackEndApp.dto.Goal.AddGoalDto;
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

    @Transactional
    public void addingGoal(AddGoalDto addGoalDto) {
        Set<ConstraintViolation<AddGoalDto>> violations = validator.validate(addGoalDto);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (shopRepository.existsByPhoneNumber(addGoalDto.getPhoneNumber())) {
            throw RestException.shopAlreadyRegistered();
        }

        shopRepository.save(
            Shop.<Shop>builder()
            .name(addGoalDto.getName())
            .address(addGoalDto.getAddress())
            .phoneNumber(addGoalDto.getPhoneNumber())
            .build()
        );
    }

    
}
