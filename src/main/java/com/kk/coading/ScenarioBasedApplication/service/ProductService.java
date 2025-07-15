package com.kk.coading.ScenarioBasedApplication.service;

import com.kk.coading.ScenarioBasedApplication.dto.ProductDTO;
import com.kk.coading.ScenarioBasedApplication.exception.ResourceNotFoundException;
import com.kk.coading.ScenarioBasedApplication.mapper.ProductMapper;
import com.kk.coading.ScenarioBasedApplication.model.Product;
import com.kk.coading.ScenarioBasedApplication.repositity.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public ProductDTO createProduct(ProductDTO productDTO) {

        return  ProductMapper.toDto(productRepository.save(ProductMapper.toEntity(productDTO)));
    }

    public ProductDTO updateProduct(Long productId, ProductDTO updatedProduct) {
        Product existing = productRepository.findById(productId).orElseThrow(
                () -> new   ResourceNotFoundException("Product does not exit")
        );
        existing.setName(updatedProduct.name());
        existing.setPrice(updatedProduct.price());
        existing.setQuantity(updatedProduct.quantity());
        return ProductMapper.toDto(productRepository.save(existing));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product is not found " +id);
        }
        productRepository.deleteById(id);
    }
}
