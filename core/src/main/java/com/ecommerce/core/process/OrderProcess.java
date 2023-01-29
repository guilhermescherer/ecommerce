package com.ecommerce.core.process;

import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Order;

import static java.util.Objects.isNull;

public abstract class OrderProcess {

    private OrderProcess next;

    public void linkWith(OrderProcess next) {
        this.next = next;
    }

    public OrderBuilder perform(OrderData orderData) {
        OrderBuilder orderBuilder = Order.builder();
        return performChild(orderData, orderBuilder);
    }

    private OrderBuilder performChild(OrderData orderData, OrderBuilder orderBuilder) {
        OrderBuilder builder = perform(orderData, orderBuilder);
        return performNext(orderData, builder);
    }

    protected OrderBuilder performNext(OrderData orderData, OrderBuilder orderBuilder) {
        return isNull(next) ? orderBuilder : next.performChild(orderData, orderBuilder);
    }

    protected abstract OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder);
}
