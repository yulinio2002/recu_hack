package com.example.hack1_recu.infraestructure;

import com.example.hack1_recu.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
