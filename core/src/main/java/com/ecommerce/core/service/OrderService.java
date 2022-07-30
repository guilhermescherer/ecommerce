package com.ecommerce.core.service;

import com.ecommerce.core.model.Order;

public interface OrderService {
    Order save(Order order);

    Order getOrderById(Long id);
}
