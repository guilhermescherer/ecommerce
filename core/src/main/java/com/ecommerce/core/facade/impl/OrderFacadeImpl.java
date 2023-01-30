package com.ecommerce.core.facade.impl;

import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.data.UpdateStateData;
import com.ecommerce.core.facade.OrderFacade;
import com.ecommerce.core.model.Order;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.OrderService;
import com.ecommerce.common.annotation.Facade;

import static com.ecommerce.common.validator.Validator.notFoundEntity;

@Facade
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;
    private final OrderProcess orderProcess;

    public OrderFacadeImpl(OrderService orderService, OrderProcess orderProcess) {
        this.orderService = orderService;
        this.orderProcess = orderProcess;
    }

    @Override
    public Order createOrder(OrderData orderData) {
        OrderBuilder orderBuilder = orderProcess.perform(orderData);

        return orderBuilder.build(orderService);
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderService.getOrderById(id);
        notFoundEntity(Order.class, order, id);

        return order;
    }

    @Override
    public void updateState(Long id, UpdateStateData updateState) {
        Order order = this.getOrderById(id);

        orderService.updateState(order, updateState);
    }
}
