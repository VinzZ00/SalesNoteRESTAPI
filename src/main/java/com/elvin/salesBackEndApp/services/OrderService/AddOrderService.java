package com.elvin.salesBackEndApp.services.OrderService;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.order.AddOrderDto;
import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;
import com.elvin.salesBackEndApp.repository.ShopRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class AddOrderService {
    
    @Autowired private OrderRepository orderRepository;
    @Autowired private ShopRepository shopRepository;
    // @Autowired private ModelMapper modelMapper;
    @Autowired private Validator validator;

    @Transactional
    public Order addOrder(AddOrderDto addOrderDto) {
        Set<ConstraintViolation<AddOrderDto>> violations = validator.validate(addOrderDto);
        
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }

        Order order = Order.<Order>builder()
            .shop(shopRepository.findById(addOrderDto.getShopId()).get())
            .totalAmount(addOrderDto.getTotalAmount())
            .dateOrdered(addOrderDto.getDateOrdered())
            .status(addOrderDto.getStatus())
            .build();
        
        return orderRepository.save(order);
    }

}
