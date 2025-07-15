package com.kk.coading.ScenarioBasedApplication.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDTO(

    Long productId,

    @NotBlank(message = "Name can not be empty")
    String name,

    @NotNull(message = "product category can not be null")
    String category,

    @Min(value = 0,message = "Quantity must be zero or more")
    int quantity,

    boolean inStock,

    @Positive(message = "Price must be greater than zero.")
     double price
) {

}
