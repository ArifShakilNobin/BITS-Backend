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
    public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.ok(new ApiResponse(true, "Product Saved Successfully", createdProduct));


    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse(true, "Product List Retrieved Successfully", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(new ApiResponse(true, "Product Found Successfully", product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody Product updatePproduct, @PathVariable Long id) {
        Product product = productService.updateProduct(id, updatePproduct);
        return ResponseEntity.ok(new ApiResponse(true, "product Updated Successfully", product));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse(true, "Product Deleted Successfully"));


    }
}
