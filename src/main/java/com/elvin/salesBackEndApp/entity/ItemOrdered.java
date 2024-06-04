package com.elvin.salesBackEndApp.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity(name = "ItemOrdered")
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @JsonIgnore
    @JsonIgnoreProperties("items")
    private Order Order;


}
