package com.ecommerce.core.action.order;

import com.ecommerce.common.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.ProductOrder;
import com.ecommerce.core.process.OrderProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;

@Action
@Order(4)
public class CalculateOrderPriceAction extends OrderProcess {

    private static final Logger LOG = LoggerFactory.getLogger(CalculateOrderPriceAction.class);

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        BigDecimal price = orderBuilder.getProductsOrder()
                .stream()
                .map(ProductOrder::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        orderBuilder.setPrice(price);

        LOG.info(String.format("Calculated price [%s] to Order", price));

        return orderBuilder;
    }
}
