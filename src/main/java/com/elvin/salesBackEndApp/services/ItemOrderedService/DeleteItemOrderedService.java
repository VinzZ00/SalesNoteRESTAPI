package com.elvin.salesBackEndApp.services.ItemOrderedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvin.salesBackEndApp.repository.ItemOrderedRepository;

import jakarta.transaction.Transactional;

import java.util.UUID;

@Service
public class DeleteItemOrderedService {

    @Autowired private ItemOrderedRepository itemOrderedRepository;

    @Transactional
    public String deleteItemOrdered(String id) {
        if (!itemOrderedRepository.existsById(UUID.fromString(id))) return "No Item Ordered Data Found with this ID!";
        try {
            itemOrderedRepository.deleteById(UUID.fromString(id));
            return "Data Deleted!";
        } catch (Exception e) {
            return "Error Occured : " + e.getMessage();
        }
    }
}
