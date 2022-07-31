package com.ecommerce.shipping.facade.impl;

import com.ecommerce.shipping.annotation.Facade;
import com.ecommerce.shipping.data.ShippingData;
import com.ecommerce.shipping.dto.ShippingDto;
import com.ecommerce.shipping.facade.ShippingFacade;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.service.ShippingService;
import com.ecommerce.shipping.service.StateService;

import static com.ecommerce.utils.validator.Validator.notFound;

@Facade
public class ShippingFacadeImpl implements ShippingFacade {

    private final ShippingService shippingService;
    private final StateService stateService;

    public ShippingFacadeImpl(ShippingService shippingService, StateService stateService) {
        this.shippingService = shippingService;
        this.stateService = stateService;
    }

    @Override
    public ShippingDto createShipping(ShippingData shippingData) {
        State state = stateService.getStateById(shippingData.getState());
        notFound(State.class, state, shippingData.getState());

        ShippingCompany company = shippingService.getShippingCompanyByState(state);

        // getShippingPriceByCompanyAndDestiny()
        // createOrderShipping()

        return null;
    }
}
