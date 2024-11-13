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
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }else if(Objects.equals(existingProduct.getId(), product.getId())){
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productRepository.save(existingProduct);
        }
        return ResponseEntity.ok(existingProduct);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
