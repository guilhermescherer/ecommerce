package com.ecommerce.core.repository;

import com.ecommerce.core.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
