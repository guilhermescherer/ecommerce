package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;

import java.math.BigDecimal;

public interface OrderShippingService {

    OrderShipping createOrderShipping(State state, ShippingCompany shippingCompany, BigDecimal price, Long order);
}
