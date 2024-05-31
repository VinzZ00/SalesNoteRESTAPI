package com.elvin.salesBackEndApp.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Builder;

@Entity(name = "order")
@Data
@Builder
public class Order {
    
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private double totalAmount;
    private String status;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date dateOrdered;

    // @ManyToOne
    @ManyToOne
    @JoinColumn(name = "ordered by", referencedColumnName = "id")
    @JsonIgnoreProperties("orders")
    private Shop shop;
}
