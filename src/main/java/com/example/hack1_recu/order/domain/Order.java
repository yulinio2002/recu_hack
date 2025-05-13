package com.example.hack1_recu.order.domain;

import com.example.hack1_recu.product.domain.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @ManyToMany
    private List<Product> products;

    // Getters, Setters, Constructors
}