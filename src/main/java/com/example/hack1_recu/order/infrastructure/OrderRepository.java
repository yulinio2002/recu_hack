package com.example.hack1_recu.order.infrastructure;

import com.example.hack1_recu.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
