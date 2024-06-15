package com.elvin.salesBackEndApp.services.ItemOrderedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.Optional;

import com.elvin.salesBackEndApp.dto.exception.RestException;
import com.elvin.salesBackEndApp.dto.itemordered.UpdateItemOrderedDto;
import com.elvin.salesBackEndApp.entity.ItemOrdered;
import com.elvin.salesBackEndApp.repository.ItemOrderedRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UpdateItemOrderedService {
    @Autowired private ItemOrderedRepository itemOrderedRepository;
    @Autowired private Validator validator;

    @Transactional
    public ItemOrdered updateItemOrdered(UpdateItemOrderedDto updateItemOrderedDto) {
        Set<ConstraintViolation<UpdateItemOrderedDto>> violations = validator.validate(updateItemOrderedDto);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);

        Optional<ItemOrdered> itemOrdereOptional = itemOrderedRepository.findById(UUID.fromString(updateItemOrderedDto.getId()));

        if (!itemOrdereOptional.isPresent()) throw RestException.itemNotFound();

        ItemOrdered itemOrdered = itemOrdereOptional.get(); 

        itemOrdered.setName(updateItemOrderedDto.getName());
        itemOrdered.setQuantity(updateItemOrderedDto.getQuantity());
        itemOrdered.setPrice(updateItemOrderedDto.getPrice());

        return itemOrderedRepository.save(itemOrdered);
    }
}
