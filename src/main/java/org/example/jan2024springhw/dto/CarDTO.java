package org.example.jan2024springhw.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    private int id;

    @NotBlank
    private String brand;
    @Min(value = 0, message = "price min 0")
    @Max(value = 1_000_000, message = "price max 1 000 000")
    private int price;
    @Min(value = 1990, message = "price min 1990")
    @Max(value = 2024, message = "price max 2024")
    private int year;
}