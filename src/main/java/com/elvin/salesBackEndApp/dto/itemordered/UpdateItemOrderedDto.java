package com.elvin.salesBackEndApp.dto.itemordered;

import com.elvin.salesBackEndApp.validationClass.UUIDValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotNull
    private int quantity;
    
    @NotNull
    private double price;
    
}
