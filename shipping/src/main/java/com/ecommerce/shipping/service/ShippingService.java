package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.model.ShippingCompany;

public interface ShippingService {

    ShippingCompany getShippingCompanyByState(State state);
}
