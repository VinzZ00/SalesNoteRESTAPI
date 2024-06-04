package com.elvin.salesBackEndApp.services.ItemOrderedService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.entity.ItemOrdered;
import com.elvin.salesBackEndApp.repository.ItemOrderedRepository;
import com.elvin.salesBackEndApp.repository.OrderRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GetItemOrderedService {
    @Autowired ModelMapper modelMapper;
    @Autowired ItemOrderedRepository itemOrderedRepository;
    
    public List<ItemOrdered> getItemOrderedByOrderId(String orderIdString) {
        List<ItemOrdered> itemOrdereds = itemOrderedRepository.findAll();

        return itemOrdereds.stream()
            .filter(itemOrdered -> itemOrdered
                .getOrder()
                .getId()
                .toString()
                .equals(orderIdString))
            .collect(Collectors.toList());
    }
}
