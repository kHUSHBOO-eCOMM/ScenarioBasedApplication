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

        Map<Long, Integer> productStock = new HashMap<>();
        productStock.put(001l, 100);
        productStock.put(002l, 50);
        productStock.put(003l, 400);
        productStock.put(004l, 10);


        List<Order> orders = Arrays.asList(
                new Order("001",
                Arrays.asList(new Product(001l, 20),
                        new Product(002l, 60),
                        new Product(003l, 300)
                ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product(004l, 20),
                                new Product(002l, 20),
                                new Product(001l, 20)
                        ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product(001l, 20),
                                new Product(003l, 20),
                                new Product(002l, 20)
                        ), 100.00, LocalDateTime.now()),
                new Order("001",
                        Arrays.asList(new Product(001l, 20),
                                new Product(003l, 20),
                                new Product(002l, 20)
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
