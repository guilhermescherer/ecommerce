package com.ecommerce.core.action.order;

import com.ecommerce.core.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.process.OrderProcess;
import org.springframework.core.annotation.Order;

@Action
@Order(5)
public class OrderShippingIntegrationAction extends OrderProcess {

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        return performNext(orderData, orderBuilder);
    }
}