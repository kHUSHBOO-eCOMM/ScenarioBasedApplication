package com.kk.coading.ScenarioBasedApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String category;
    private int quantity;
    private boolean inStock;
    private double price;

    public Product(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
