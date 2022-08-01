package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.repository.OrderShippingRepository;
import com.ecommerce.shipping.service.OrderShippingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderShippingServiceImpl implements OrderShippingService {

    private final OrderShippingRepository orderShippingRepository;

    public OrderShippingServiceImpl(OrderShippingRepository orderShippingRepository) {
        this.orderShippingRepository = orderShippingRepository;
    }

    @Override
    public OrderShipping createOrderShipping(State state, ShippingCompany shippingCompany, BigDecimal price, Long order) {
        OrderShipping orderShipping = new OrderShipping();

        orderShipping.setOrder(order);
        orderShipping.setState(state);
        orderShipping.setPrice(price);
        orderShipping.setShippingCompany(shippingCompany);

        return orderShippingRepository.save(orderShipping);
    }
}
