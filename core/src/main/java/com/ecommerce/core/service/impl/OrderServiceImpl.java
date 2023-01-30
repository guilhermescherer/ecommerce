package com.ecommerce.core.service.impl;

import com.ecommerce.core.data.UpdateOrderStateData;
import com.ecommerce.core.model.Order;
import com.ecommerce.core.model.State;
import com.ecommerce.core.repository.OrderRepository;
import com.ecommerce.core.service.OrderService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.ecommerce.core.model.State.METHOD_PREFIX;
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
    public void updateState(Order order, UpdateOrderStateData updateOrderState) {
        String name = updateOrderState.getName();
        State state = order.getState();

        try {
            String methodName = METHOD_PREFIX + name;
            Method method = state.getClass().getMethod(methodName, Order.class);
            method.invoke(state, order);

            this.save(order);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
