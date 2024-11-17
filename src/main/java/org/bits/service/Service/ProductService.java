package org.bits.service.Service;

import lombok.RequiredArgsConstructor;
import org.bits.service.Domain.Entity.Product;
import org.bits.service.Domain.Response.ApiResponse;
import org.bits.service.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
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

    public Product updateProduct( Long id,  Product Product) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setName(Product.getName());
        product.setPrice(Product.getPrice());
        Product updatedProduct = productRepository.save(Product);
        return updatedProduct;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
