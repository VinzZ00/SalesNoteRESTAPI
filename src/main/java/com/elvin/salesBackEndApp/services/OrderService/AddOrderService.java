package com.elvin.salesBackEndApp.services.OrderService;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.order.AddOrderDto;
import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class AddOrderService {
    
    @Autowired private OrderRepository orderRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private Validator validator;

    public Order addOrder(AddOrderDto addOrderDto) {
        Set<ConstraintViolation<AddOrderDto>> violations = validator.validate(addOrderDto);

        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        
        return orderRepository.save(modelMapper.map(addOrderDto, Order.class));
    }

}
