package com.example.hack1_recu.event;

import java.util.List;

public class OrderCreatedEvent {
    private final String id;
    private final String email;
    private final List<String> products;

    public OrderCreatedEvent(String id, String email, List<String> products) {
        this.id = id;
        this.email = email;
        this.products = products;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public List<String> getProducts() { return products; }
}