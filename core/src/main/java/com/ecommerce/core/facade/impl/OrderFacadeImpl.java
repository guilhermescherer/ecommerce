package com.ecommerce.core.facade.impl;

import com.ecommerce.core.annotation.Facade;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.dto.OrderDto;
import com.ecommerce.core.facade.OrderFacade;
import com.ecommerce.core.model.Order;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.OrderService;

@Facade
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;
    private final OrderProcess orderProcess;

    public OrderFacadeImpl(OrderService orderService, OrderProcess orderProcess) {
        this.orderService = orderService;
        this.orderProcess = orderProcess;
    }

    public OrderDto createOrder(OrderData orderData) {
        OrderBuilder orderBuilder = new OrderBuilder();
        orderProcess.perform(orderData, orderBuilder);
        Order order = orderBuilder.build(orderService);

        return new OrderDto(order);
    }
}
