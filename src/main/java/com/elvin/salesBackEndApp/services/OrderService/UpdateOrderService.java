package com.elvin.salesBackEndApp.services.OrderService;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.exception.RestException;
import com.elvin.salesBackEndApp.dto.order.UpdateOrderDto;
import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Validator;

@Service
public class UpdateOrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private Validator validator;
    @Autowired private ModelMapper modelMapper;

    @Transactional
    public Order updateOrderService(UpdateOrderDto updateOrderDto) {
        Optional<Order> existOrder = orderRepository.findById(UUID.fromString(updateOrderDto.getId()));

        if (!existOrder.isPresent()) throw RestException.orderNotFound();

        Order o = existOrder.get();
        o.setTotalAmount(updateOrderDto.getTotalAmount());
        o.setStatus(updateOrderDto.getStatus());

        return orderRepository.save(o);
    }
}
