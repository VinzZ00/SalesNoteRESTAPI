package com.elvin.salesBackEndApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elvin.salesBackEndApp.entity.ItemOrdered;

import java.util.UUID;

public interface ItemOrderedRepositorry extends JpaRepository<ItemOrdered, UUID> {
    
} 
