package com.example.hack1_recu.listener;

import com.example.hack1_recu.order.events.OrderCreatedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationListener.class);

    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("Enviando correo de confirmación a: " + event.getOrder().getEmail());
    }
}