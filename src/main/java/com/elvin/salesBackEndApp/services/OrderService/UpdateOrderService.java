package com.elvin.salesBackEndApp.services.OrderService;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.dto.Exception.RestException;
import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;

import jakarta.validation.Validator;

@Service
public class UpdateOrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private Validator validator;
    @Autowired private ModelMapper modelMapper;

    Order updateOrderService(Order order) {
        Optional<Order> existOrder = orderRepository.findById(order.getId());

        if (!existOrder.isPresent()) throw RestException.orderNotFound();

        orderRepository.save(order);

        return order;
    }
}
