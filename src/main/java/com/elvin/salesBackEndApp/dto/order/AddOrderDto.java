package com.elvin.salesBackEndApp.dto.order;


import java.util.Date;

import com.elvin.salesBackEndApp.entity.Shop;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOrderDto {
    
    @NotBlank
    private double totalAmount;

    @NotBlank
    private String status;

    @NotBlank
    private Date dateOrdered;

    @NotBlank
    private Shop shop;
    
}
