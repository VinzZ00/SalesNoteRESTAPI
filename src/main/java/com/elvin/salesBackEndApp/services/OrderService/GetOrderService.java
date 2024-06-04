package com.elvin.salesBackEndApp.services.OrderService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;

@Service
public class GetOrderService {
    @Autowired private OrderRepository orderRepository;

    public List<Order> getOrders(String shopId) {
        List<Order> orders = orderRepository.findAll();

        return orders
            .stream()
            .filter(order -> order
                .getShop()
                .getId()
                .toString()
                .equals(shopId)
            )
            .collect(Collectors.toList());
    }

    public List<Order> getOrdersByDate(String shopId, Date date) {
        return orderRepository.getOrderByShopAndDateOrders(shopId, date);
    }

}
