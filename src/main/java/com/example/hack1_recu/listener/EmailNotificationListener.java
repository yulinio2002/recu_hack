package com.example.hack1_recu.listener;

import com.example.hack1_recu.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("[EmailNotification] Envió de confirmación a {} para el pedido {}", event.getEmail(), event.getId());
    }
}