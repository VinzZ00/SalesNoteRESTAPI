package com.elvin.salesBackEndApp.services.ItemOrderedService;

import java.util.Set;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.itemordered.AddItemOrderedDto;
import com.elvin.salesBackEndApp.entity.ItemOrdered;
import com.elvin.salesBackEndApp.repository.ItemOrderedRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator; 

@Service
public class AddItemOrderedService {
    
    @Autowired private ItemOrderedRepository itemOrderedRepository;
    @Autowired private Validator validator;
    @Autowired private ModelMapper modelMapper;

    @Transactional
    public ItemOrdered addOrder(AddItemOrderedDto addOrderItemDto) {
        Set<ConstraintViolation<AddItemOrderedDto>> violations = validator.validate(addOrderItemDto);
        
        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);
        
        return itemOrderedRepository.save(modelMapper.map(addOrderItemDto, ItemOrdered.class));
    }

}
