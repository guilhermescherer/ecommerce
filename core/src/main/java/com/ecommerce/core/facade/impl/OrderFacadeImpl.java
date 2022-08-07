package com.ecommerce.core.facade.impl;

import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.data.UpdateOrderStateTypeData;
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
    public void orderCollected(Long id, UpdateOrderStateTypeData type) {
        Order order = this.getOrderById(id);

        if(UpdateOrderStateTypeData.TO_COLLECTED.equals(type)) {
            orderService.updateOrderToCollected(order);
        } else if (UpdateOrderStateTypeData.TO_DELIVERED.equals(type)) {
            orderService.updateOrderToDelivered(order);
        }

        orderService.save(order);
    }
}
