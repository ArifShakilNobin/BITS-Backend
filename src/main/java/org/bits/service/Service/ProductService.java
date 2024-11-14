package org.bits.service.Service;

import lombok.RequiredArgsConstructor;
import org.bits.service.Domain.Entity.Product;
import org.bits.service.Domain.Response.ApiResponse;
import org.bits.service.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public ResponseEntity<?> saveProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<?> getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return ResponseEntity.ok(product);
    }

    public ApiResponse deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return new ApiResponse(true, "Product deleted successfully", null);
        } else {
            return new ApiResponse(false, "Product not found", null);
        }
    }

    public ResponseEntity<?> updateProduct(Product product) {
        // Find the existing product by ID
        Optional<Product> optionalProduct = productRepository.findById(product.getId());

        // Check if product with given ID exists
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Update fields in the existing product
        Product existingProduct = optionalProduct.get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        // Save the updated product (JPA will update instead of insert since the ID is present)
        productRepository.save(existingProduct);

        return ResponseEntity.ok(existingProduct);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
