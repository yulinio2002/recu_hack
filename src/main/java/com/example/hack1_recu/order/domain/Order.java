package com.example.hack1_recu.order.domain;

import com.example.hack1_recu.product.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String email;

    @ManyToMany
    private List<Product> products;

    // Getters, Setters, Constructors
}