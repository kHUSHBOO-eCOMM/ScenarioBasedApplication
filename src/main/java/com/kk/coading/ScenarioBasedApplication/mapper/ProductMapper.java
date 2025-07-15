package com.kk.coading.ScenarioBasedApplication.mapper;

import com.kk.coading.ScenarioBasedApplication.dto.ProductDTO;
import com.kk.coading.ScenarioBasedApplication.model.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product){

        return new ProductDTO(product.getProductId(), product.getName(),
                product.getCategory(), product.getQuantity(), product.isInStock(), product.getPrice());

            }
            public static Product toEntity(ProductDTO dto){
                return Product.builder()
                        .productId(dto.productId())
                        .name(dto.name())
                        .price(dto.price())
                        .quantity(dto.quantity())
                        .category(dto.category())
                        .inStock(dto.inStock())
                        .build();
            }
}
