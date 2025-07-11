package com.kk.coading.ScenarioBasedApplication.service;

import com.kk.coading.ScenarioBasedApplication.model.Order;
import com.kk.coading.ScenarioBasedApplication.model.Product;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ReportGenerator {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("12",
                        Arrays.asList(
                                new Product("1","sari","clothing",2, true, 1232.00),
                                new Product("2", "Samsung lite", "Electronic", 1, true, 50000),
                                new Product("3", "Samsung node 10", "Electronic", 1, false, 54000),
                                new Product("4", "Maharaja Mixture", "Electronic", 1, false, 9000)

                                ), 15000, LocalDateTime.now().minusHours(3)),
                new Order("12",
                        Arrays.asList(
                                new Product("5","sari","clothing",2, true, 112.00),
                                new Product("6", "Shoes", "Footware", 1, true, 500),
                                new Product("7", "Samsung tsirt", "clothing", 1, false, 500),
                                new Product("8", "Maharaja", "util", 1, true, 90)

                        ), 500, LocalDateTime.now().minusHours(3)),

                new Order("12",
                        Arrays.asList(
                                new Product("9","sari","clothing",2, true, 1232.00),
                                new Product("10", "key", "Decorative", 1, true, 50),
                                new Product("11", "Top", "Clothing", 1, false, 50),
                                new Product("12", "cable", "Electronic", 1, false, 90)

                        ), 500, LocalDateTime.now().minusHours(26))


                );

        Map<String, Integer> mapOfCategoryAndQuantity = orders.stream()
                .filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() >= 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.isInStock())
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->  e1, LinkedHashMap::new))
                ;
        System.out.println(mapOfCategoryAndQuantity);


    }
}
