package com.elvin.salesBackEndApp.services.ItemOrderedService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.entity.ItemOrdered;
import com.elvin.salesBackEndApp.repository.ItemOrderedRepository;

import java.util.*;

@Service
public class GetItemOrderedService {
    @Autowired ModelMapper modelMapper;
    @Autowired ItemOrderedRepository itemOrderedRepository;
    
    public List<ItemOrdered> getItemOrderedByOrderId(String orderIdString) {
        return itemOrderedRepository.findByOrderId(UUID.fromString(orderIdString));
    }
}
