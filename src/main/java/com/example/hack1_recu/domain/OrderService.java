package com.example.hack1_recu.domain;

import com.example.hack1_recu.event.OrderCreatedEvent;
import com.example.hack1_recu.infraestructure.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher publisher;

    public OrderService(OrderRepository orderRepository,
                        ApplicationEventPublisher publisher) {
        this.orderRepository = orderRepository;
        this.publisher = publisher;
    }

    /**
     * Guarda el pedido y dispara el evento con el ID ya generado
     */
    public Order createOrder(Order order) {
        Order saved = orderRepository.save(order);
        publisher.publishEvent(
                new OrderCreatedEvent(
                        saved.getId().toString(),
                        saved.getEmail(),
                        saved.getProducts()
                )
        );
        return saved;
    }
}