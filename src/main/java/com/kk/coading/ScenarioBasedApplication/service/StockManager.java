package com.kk.coading.ScenarioBasedApplication.service;

import com.kk.coading.ScenarioBasedApplication.model.Order;
import com.kk.coading.ScenarioBasedApplication.model.Product;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StockManager {

   /* You need to identify orders that have issues with stock availability.
   Specifically, if the ordered quantity of a product exceeds the available stock,
    that order should be flagged.
    */

    public static void main(String[] args) {

        Map<String, Integer> productStock = new HashMap<>();
        productStock.put("p001", 100);
        productStock.put("p002", 50);
        productStock.put("p003", 400);
        productStock.put("p004", 10);


        List<Order> orders = Arrays.asList(
                new Order("001",
                Arrays.asList(new Product("p001", 20),
                        new Product("p002", 60),
                        new Product("p003", 300)
                ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product("p004", 20),
                                new Product("p002", 20),
                                new Product("p001", 20)
                        ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product("p001", 20),
                                new Product("p003", 20),
                                new Product("p002", 20)
                        ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product("p001", 20),
                                new Product("p003", 20),
                                new Product("p002", 20)
                        ), 100.00, LocalDateTime.now())

        );

        List<String> problematicOrder = orders
                .stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> {
                            int availableStock = productStock.get(product.getProductId());
                            return availableStock < product.getQuantity();
                        })).map(Order::getOrderId).toList();



    }
}
