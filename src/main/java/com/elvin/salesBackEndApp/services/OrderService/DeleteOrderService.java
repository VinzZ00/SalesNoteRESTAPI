package com.elvin.salesBackEndApp.services.OrderService;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvin.salesBackEndApp.repository.OrderRepository;

@Service
public class DeleteOrderService {
    @Autowired private OrderRepository orderRepository;

    public String deleteOrderService(String orderId) {
        if (!orderRepository.existsById(UUID.fromString(orderId))) return "No Order Data Found with this ID!";
        try {
            orderRepository.deleteById(UUID.fromString(orderId));
            return "Data Deleted!";
        } catch (Exception e) {
            return "Error Occured : " + e.getMessage();
        } 
    }

}
