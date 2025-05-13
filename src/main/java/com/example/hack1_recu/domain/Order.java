package com.example.hack1_recu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "orders")               // ← aquí renombramos la tabla
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ElementCollection
    @CollectionTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product")
    private List<String> products;
}
