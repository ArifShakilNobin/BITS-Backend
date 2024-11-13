package org.bits.service.Api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bits.service.Domain.Entity.Product;
import org.bits.service.Domain.Response.ApiResponse;
import org.bits.service.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiResponse response = new ApiResponse(true, "Products fetched successfully", products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
