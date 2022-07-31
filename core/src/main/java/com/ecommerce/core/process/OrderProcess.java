package com.ecommerce.core.process;

import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;

import static java.util.Objects.isNull;

public abstract class OrderProcess {

    private OrderProcess next;

    public void linkWith(OrderProcess next) {
        this.next = next;
    }

    public abstract OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder);

    protected OrderBuilder performNext(OrderData orderData, OrderBuilder orderBuilder) {
        return isNull(next) ? orderBuilder : next.perform(orderData, orderBuilder);
    }
}
