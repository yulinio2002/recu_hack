package com.example.hack1_recu.product.domain;

import com.example.hack1_recu.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    public final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
