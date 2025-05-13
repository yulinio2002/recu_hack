package com.example.hack1_recu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String code;      // ej: "A", "B", "C"
    private Integer stock;
}