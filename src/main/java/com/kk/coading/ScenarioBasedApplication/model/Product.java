package com.kk.coading.ScenarioBasedApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String category;
    private int quantity;
    private boolean inStock;
    private double price;

    public Product(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
