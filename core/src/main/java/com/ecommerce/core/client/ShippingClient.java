package com.ecommerce.core.client;

import com.ecommerce.shipping.data.OrderShippingData;
import com.ecommerce.shipping.dto.OrderShippingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("shipping")
public interface ShippingClient {

    @PostMapping("/shipping")
    OrderShippingDto createOrderShipping(OrderShippingData orderData);
}
