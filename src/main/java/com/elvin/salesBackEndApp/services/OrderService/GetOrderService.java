package com.elvin.salesBackEndApp.services.OrderService;

import java.util.List;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.repository.OrderRepository;

public class GetOrderService {
    @Autowired private OrderRepository orderRepository;

    public List<Order> getOrdersDTO(String shopId) {
        return orderRepository.findByShop(shopId);
    }

    public List<Order> getOrdersDTOByDate(String shopId, Date date) {
        return orderRepository.findByShopAndDateOrders(shopId, date);
    }

}
