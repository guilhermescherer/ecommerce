package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.OrderShipping;

public interface OrderShippingService {

    OrderShipping save(OrderShipping orderShipping);

    OrderShipping getOrderShippingById(Long id);
}
