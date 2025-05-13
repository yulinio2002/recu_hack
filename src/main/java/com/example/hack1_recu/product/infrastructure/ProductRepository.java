package com.example.hack1_recu.product.infrastructure;

import com.example.hack1_recu.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
