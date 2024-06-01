package com.elvin.salesBackEndApp.dto.itemordered;

import com.elvin.salesBackEndApp.validationClass.UUIDValidation;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateItemOrderedDto {
    @NotBlank
    private String name;

    @NotBlank @UUIDValidation
    private String id;

    @NotBlank
    private int quantity;
    
    @NotBlank
    private double price;
    
}
