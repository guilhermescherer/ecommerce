package com.ecommerce.shipping.facade;

import com.ecommerce.shipping.data.ShippingData;
import com.ecommerce.shipping.dto.ShippingDto;

public interface ShippingFacade {

    ShippingDto createShipping(ShippingData shippingData);
}
