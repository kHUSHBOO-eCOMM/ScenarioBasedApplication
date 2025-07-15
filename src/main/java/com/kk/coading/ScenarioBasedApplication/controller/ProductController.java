package com.kk.coading.ScenarioBasedApplication.controller;

import com.kk.coading.ScenarioBasedApplication.dto.ProductDTO;
import com.kk.coading.ScenarioBasedApplication.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "Manage products in inventory")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
       return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get a products detail", description = "Get a products detail from product id")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId){
       return  ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    @Operation(summary = "Create product", description = "Creates a new product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PostMapping("/{productId}")
    @Operation(summary = "Update product", description = "Update product for a productId")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId ,@Valid @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.updateProduct(productId, productDTO));
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Delete product", description = "Delete product for a productId")
    public ResponseEntity<String> delete(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product has been deleted successfully" + productId);
    }
}
