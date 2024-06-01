package com.elvin.salesBackEndApp.dto.itemordered;

import com.elvin.salesBackEndApp.entity.Order;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemOrderedDto {
    @NotBlank
    private String productName;

    @NotBlank
    private int quantity;

    @NotBlank
    private double price;

    @NotBlank
    private Order order;
}
