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
                                new Product(1l,"sari","clothing",2, true, 1232.00),
                                new Product(2l, "Samsung lite", "Electronic", 1, true, 50000),
                                new Product(3l, "Samsung node 10", "Electronic", 1, false, 54000),
                                new Product(4l, "Maharaja Mixture", "Electronic", 1, false, 9000)

                                ), 15000, LocalDateTime.now().minusHours(3)),
                new Order("12",
                        Arrays.asList(
                                new Product(5l,"sari","clothing",2, true, 112.00),
                                new Product(6l, "Shoes", "Footware", 1, true, 500),
                                new Product(7l, "Samsung tsirt", "clothing", 1, false, 500),
                                new Product(8l, "Maharaja", "util", 1, true, 90)

                        ), 500, LocalDateTime.now().minusHours(3)),

                new Order("12",
                        Arrays.asList(
                                new Product(9l,"sari","clothing",2, true, 1232.00),
                                new Product(10l, "key", "Decorative", 1, true, 50),
                                new Product(11l, "Top", "Clothing", 1, false, 50),
                                new Product(12l, "cable", "Electronic", 1, false, 90)

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
