package com.elvin.salesBackEndApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elvin.salesBackEndApp.entity.ItemOrdered;

import java.util.UUID;
import java.util.List;

public interface ItemOrderedRepository extends JpaRepository<ItemOrdered, UUID> {
    List<ItemOrdered> findByOrderId(UUID orderId);
} 
