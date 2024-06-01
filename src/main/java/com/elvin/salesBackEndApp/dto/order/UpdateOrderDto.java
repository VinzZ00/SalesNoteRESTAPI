package com.elvin.salesBackEndApp.dto.order;

import java.util.UUID;

import com.elvin.salesBackEndApp.validationClass.UUIDValidation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDto {
    
    @NotBlank @UUIDValidation
    private UUID id;

    @NotBlank
    private double totalAmount;
    private String status;

}
