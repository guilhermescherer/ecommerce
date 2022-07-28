package com.ecommerce.core.service.impl;

import com.ecommerce.core.model.Order;
import com.ecommerce.core.repository.OrderRepository;
import com.ecommerce.core.service.OrderService;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        order.getProductsOrder().forEach(po -> {
            if(isNull(po.getOrder())) {
                po.setOrder(order);
            }
        });

        return orderRepository.saveAndFlush(order);
    }
}
