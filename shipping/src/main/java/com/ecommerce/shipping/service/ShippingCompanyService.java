package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.shipping.model.ShippingCompany;

import java.math.BigDecimal;

public interface ShippingCompanyService {

    ShippingCompany getShippingCompanyByAddress(DeliveryAddress address);

    BigDecimal getShippingPriceByAddress(ShippingCompany company, DeliveryAddress address);
}
