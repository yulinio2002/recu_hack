package com.example.hack1_recu.order.domain;

import com.example.hack1_recu.order.events.OrderCreatedEvent;
import com.example.hack1_recu.order.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher eventPublisher;

    public OrderService(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    public void createOrder(Order order) {
        Order saved = orderRepository.save(order);
        eventPublisher.publishEvent(new OrderCreatedEvent(this, saved));
        //return saved;
    }
}