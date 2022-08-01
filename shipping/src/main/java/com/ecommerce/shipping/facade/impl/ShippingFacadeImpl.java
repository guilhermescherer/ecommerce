package com.ecommerce.shipping.facade.impl;

import com.ecommerce.shipping.annotation.Facade;
import com.ecommerce.shipping.data.ShippingData;
import com.ecommerce.shipping.dto.ShippingDto;
import com.ecommerce.shipping.facade.ShippingFacade;
import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.service.OrderShippingService;
import com.ecommerce.shipping.service.ShippingCompanyService;
import com.ecommerce.shipping.service.StateService;

import java.math.BigDecimal;

import static com.ecommerce.shipping.validator.Validator.notFoundCompanyToState;
import static com.ecommerce.utils.validator.Validator.notFoundEntity;

@Facade
public class ShippingFacadeImpl implements ShippingFacade {

    private final ShippingCompanyService shippingCompanyService;
    private final StateService stateService;
    private final OrderShippingService orderShippingService;

    public ShippingFacadeImpl(ShippingCompanyService shippingCompanyService, StateService stateService, OrderShippingService orderShippingService) {
        this.shippingCompanyService = shippingCompanyService;
        this.stateService = stateService;
        this.orderShippingService = orderShippingService;
    }

    @Override
    public ShippingDto createShipping(ShippingData shippingData) {
        State state = stateService.getStateById(shippingData.getState());
        notFoundEntity(State.class, state, shippingData.getState());

        ShippingCompany company = shippingCompanyService.getShippingCompanyByState(state);
        notFoundCompanyToState(company, state);

        BigDecimal price = shippingCompanyService.getShippingPriceByState(company, state);

        OrderShipping orderShipping = orderShippingService.createOrderShipping(state, company, price, shippingData.getOrder());

        return new ShippingDto(orderShipping);
    }
}
