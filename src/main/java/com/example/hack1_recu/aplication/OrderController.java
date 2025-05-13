package com.example.hack1_recu.aplication;

import com.example.hack1_recu.domain.Order;
import com.example.hack1_recu.domain.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }
}