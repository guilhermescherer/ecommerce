package com.ecommerce.core.action.order;

import com.ecommerce.common.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.client.ShippingClient;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Address;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.shipping.data.OrderShippingData;
import com.ecommerce.shipping.dto.OrderShippingDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Action
@Order(5)
public class OrderShippingIntegrationAction extends OrderProcess {

    private static final Logger LOG = LoggerFactory.getLogger(OrderShippingIntegrationAction.class);

    private final ShippingClient shippingClient;

    @Autowired
    public OrderShippingIntegrationAction(ShippingClient shippingClient) {
        this.shippingClient = shippingClient;
    }

    @Override
    @CircuitBreaker(name = "orderShipping", fallbackMethod = "performShippingProblem")
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        OrderShippingData orderShippingData = new OrderShippingData();

        Address address = orderBuilder.getOrder().getAddress();

        orderShippingData.setNumber(address.getNumber());
        orderShippingData.setStreet(address.getStreet());
        orderShippingData.setCity(address.getCity());
        orderShippingData.setState(address.getState().name());

        LOG.info("Requesting OrderShipping to Shipping API");

        OrderShippingDto orderShipping = shippingClient.createOrderShipping(orderShippingData);

        orderBuilder.withShipping(orderShipping.getId());

        LOG.info(String.format("OrderShipping [%d] added to Order", orderShipping.getId()));

        return orderBuilder;
    }

    public OrderBuilder performShippingProblem(OrderData orderData, OrderBuilder orderBuilder, Exception ex) {
        orderBuilder.withShippingProblemState();
        return orderBuilder;
    }
}