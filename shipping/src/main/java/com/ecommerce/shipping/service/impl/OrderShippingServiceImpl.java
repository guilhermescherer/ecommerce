package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.repository.OrderShippingRepository;
import com.ecommerce.shipping.service.OrderShippingService;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class OrderShippingServiceImpl implements OrderShippingService {

    private final OrderShippingRepository orderShippingRepository;

    public OrderShippingServiceImpl(OrderShippingRepository orderShippingRepository) {
        this.orderShippingRepository = orderShippingRepository;
    }

    @Override
    public OrderShipping save(OrderShipping orderShipping) {
        return orderShippingRepository.save(orderShipping);
    }

    @Override
    public OrderShipping getOrderShippingById(Long id) {
        return nonNull(id) ? orderShippingRepository.findById(id).orElse(null) : null;
    }
}
