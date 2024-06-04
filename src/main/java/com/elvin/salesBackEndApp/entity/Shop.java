package com.elvin.salesBackEndApp.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shops")
@Builder
@JsonIgnoreProperties("id")
public class Shop {

    @Id @GeneratedValue 
    private UUID id;

    @Column(nullable = false)
    private String name;
    private String address;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<Order> orders;
    
    
}
