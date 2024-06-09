package com.elvin.salesBackEndApp.entity;

import java.util.Date;

import java.util.UUID;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    
    @Id @GeneratedValue @JsonIgnore
    private UUID id;

    @Column(nullable = false)
    private double totalAmount;
    private String status;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date dateOrdered;

    // @ManyToOne
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordered by", referencedColumnName = "id")
    @JsonIgnore
    @JsonIgnoreProperties("order")
    private Shop shop;

    @OneToMany(mappedBy = "Order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemOrdered> items;
}
