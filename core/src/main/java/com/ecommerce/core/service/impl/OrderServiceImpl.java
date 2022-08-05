package com.ecommerce.core.service.impl;

import com.ecommerce.core.model.Order;
import com.ecommerce.core.repository.OrderRepository;
import com.ecommerce.core.service.OrderService;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        order.getProductsOrder().stream()
                .filter(po -> isNull(po.getOrder()))
                .forEach(po -> po.setOrder(order));

        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return nonNull(id) ? orderRepository.findById(id).orElse(null) : null;
    }

    @Override
    public void updateOrderToCollected(Order order) {
        order.getState().toCollected(order);
    }

    @Override
    public void updateOrderToDelivered(Order order) {
        order.getState().toDelivered(order);
    }
}
