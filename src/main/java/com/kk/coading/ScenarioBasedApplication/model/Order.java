package com.kk.coading.ScenarioBasedApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private List<Product> products;
    private double totalValue;
    private LocalDateTime orderTime;

}
