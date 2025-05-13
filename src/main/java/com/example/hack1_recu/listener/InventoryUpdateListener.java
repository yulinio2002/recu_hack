package com.example.hack1_recu.listener;
import com.example.hack1_recu.infraestructure.ProductRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.hack1_recu.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);
    private final ProductRepository productRepo;

    public InventoryUpdateListener(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @EventListener
    @Transactional
    public void handleOrderCreated(OrderCreatedEvent event) {
        for (String code : event.getProducts()) {
            productRepo.findById(code).ifPresentOrElse(prod -> {
                prod.setStock(prod.getStock() - 1);
                productRepo.save(prod);
                logger.info("[InventoryUpdate] Stock de {} ahora {}", code, prod.getStock());
            }, () -> {
                logger.warn("[InventoryUpdate] Producto {} no encontrado", code);
            });
        }
    }
}