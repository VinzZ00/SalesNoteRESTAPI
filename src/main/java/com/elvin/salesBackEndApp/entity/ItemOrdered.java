package com.elvin.salesBackEndApp.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Builder;

@Entity(name = "itemOrder")
@Data
@Builder
public class ItemOrdered {
    
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;
    private int quantity;
    private double price;

    // @ManyToOne
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @JsonIgnoreProperties("items")
    private Order orderId;


}
