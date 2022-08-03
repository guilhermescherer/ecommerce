package com.ecommerce.shipping.facade;

import com.ecommerce.shipping.data.OrderShippingData;
import com.ecommerce.shipping.dto.OrderShippingDto;

public interface OrderShippingFacade {

    OrderShippingDto createOrderShipping(OrderShippingData orderShippingData);

    OrderShippingDto getOrderShippingById(Long id);
}
