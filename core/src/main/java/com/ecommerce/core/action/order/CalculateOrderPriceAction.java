package com.ecommerce.core.action.order;

import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.ProductOrder;

import java.math.BigDecimal;

@Action
public class CalculateOrderPriceAction extends OrderProcess {

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        BigDecimal price = orderBuilder.getProductsOrder()
                .stream()
                .map(ProductOrder::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        orderBuilder.setPrice(price);

        return performNext(orderData, orderBuilder);
    }
}
