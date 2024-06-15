package com.elvin.salesBackEndApp.dto.order;

import java.util.UUID;

import com.elvin.salesBackEndApp.validationClass.UUIDValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDto {
    
    @NotBlank @UUIDValidation
    private String id;

    @NotNull
    private double totalAmount;

    @NotBlank
    private String status;

}
