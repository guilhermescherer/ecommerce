package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.model.ShippingCompany;

import java.math.BigDecimal;

public interface ShippingCompanyService {

    ShippingCompany getShippingCompanyByState(State state);

    BigDecimal getShippingPriceByState(ShippingCompany company, State state);
}
