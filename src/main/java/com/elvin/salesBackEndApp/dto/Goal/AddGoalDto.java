package com.elvin.salesBackEndApp.dto.Goal;

import com.elvin.salesBackEndApp.validationClass.StartWith;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddGoalDto {

    @NotBlank @Size(max = 255)
    private String name, address;
    
    @NotBlank @Size(min = 10, max = 12) @StartWith(value = "08")
    private String phoneNumber;
}

