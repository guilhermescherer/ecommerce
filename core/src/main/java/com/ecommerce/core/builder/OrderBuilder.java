package com.ecommerce.core.builder;

import com.ecommerce.core.model.Address;
import com.ecommerce.core.model.Customer;
import com.ecommerce.core.model.Order;
import com.ecommerce.core.model.ProductOrder;
import com.ecommerce.core.model.State;
import com.ecommerce.core.model.state.ReceivedState;
import com.ecommerce.core.model.state.ReceivedShippingProblemState;
import com.ecommerce.core.service.OrderService;

import java.math.BigDecimal;
import java.util.List;


public class OrderBuilder {

    private final Order order;
    private State state;

    public OrderBuilder() {
        order = new Order();
        state = new ReceivedState();
    }

    public Order getOrder() {
        return order;
    }

    public void withCustomer(Customer customer) {
        order.setCustomer(customer);
    }

    public void withAddress(Address address) {
        order.setAddress(address);
    }

    public void withProductsOrder(List<ProductOrder> productOrders) {
        order.setProductsOrder(productOrders);
    }

    public void withPrice(BigDecimal price) {
        order.setPrice(price);
    }

    public void withShipping(Long id) {
        order.setShipping(id);
    }

    public void withShippingProblemState() {
        state = new ReceivedShippingProblemState();
    }

    public Order build(OrderService orderService) {
        order.setState(state);
        return orderService.save(order);
    }
}
