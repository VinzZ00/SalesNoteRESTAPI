package com.elvin.salesBackEndApp.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Entity(name = "shop")
@Builder
public class Shop {

    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;
    private String address;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "shop")
    private List<ItemOrdered> items;
    
    
}
