package com.example.hack1_recu.listener;

import com.example.hack1_recu.order.events.OrderCreatedEvent;
import com.example.hack1_recu.product.domain.Product;
import com.example.hack1_recu.product.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryUpdateListener {
    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);

    private final ProductService productService;

    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        for (Product p : event.getOrder().getProducts()) {
            Product prod = productService.findById(p.getId());
            prod.setStock(prod.getStock() - 1); // Asumimos 1 por producto
            productService.save(prod);
            logger.info("Stock actualizado para el producto: " + prod.getName());
        }
    }
}