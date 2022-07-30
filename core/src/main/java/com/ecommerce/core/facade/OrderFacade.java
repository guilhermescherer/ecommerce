package com.ecommerce.core.facade;

import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.dto.OrderDto;

public interface OrderFacade {

    OrderDto createOrder(OrderData orderData);

    OrderDto getOrderById(Long id);
}
