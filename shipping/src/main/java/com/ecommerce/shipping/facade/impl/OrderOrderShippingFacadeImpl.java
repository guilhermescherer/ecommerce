package com.ecommerce.shipping.facade.impl;

import com.ecommerce.shipping.builder.OrderShippingBuilder;
import com.ecommerce.shipping.data.OrderShippingData;
import com.ecommerce.shipping.dto.OrderShippingDto;
import com.ecommerce.shipping.facade.OrderShippingFacade;
import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.service.DeliveryAddressService;
import com.ecommerce.shipping.service.OrderShippingService;
import com.ecommerce.shipping.service.ShippingCompanyService;
import com.ecommerce.shipping.service.StateService;
import com.ecommerce.common.annotation.Facade;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static com.ecommerce.shipping.validator.CompanyValidator.notFoundCompanyToAddress;
import static com.ecommerce.common.validator.Validator.notFoundEntity;

@Facade
public class OrderOrderShippingFacadeImpl implements OrderShippingFacade {

    private final ShippingCompanyService shippingCompanyService;
    private final StateService stateService;
    private final OrderShippingService orderShippingService;
    private final DeliveryAddressService deliveryAddressService;

    public OrderOrderShippingFacadeImpl(ShippingCompanyService shippingCompanyService, StateService stateService, OrderShippingService orderShippingService,
                                        DeliveryAddressService deliveryAddressService) {
        this.shippingCompanyService = shippingCompanyService;
        this.stateService = stateService;
        this.orderShippingService = orderShippingService;
        this.deliveryAddressService = deliveryAddressService;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderShippingDto createOrderShipping(OrderShippingData orderShippingData) {
        OrderShippingBuilder orderShippingBuilder = new OrderShippingBuilder();

        DeliveryAddress address = getAddressByShippingData(orderShippingData);
        orderShippingBuilder.setDeliveryAddress(address);

        ShippingCompany company = shippingCompanyService.getShippingCompanyByAddress(address);
        notFoundCompanyToAddress(company, address);
        orderShippingBuilder.setShippingCompany(company);

        BigDecimal price = shippingCompanyService.getShippingPriceByAddress(company, address);
        orderShippingBuilder.setPrice(price);

        OrderShipping orderShipping = orderShippingBuilder.build(orderShippingService);

        return new OrderShippingDto(orderShipping);
    }

    @Override
    public OrderShippingDto getOrderShippingById(Long id) {
        OrderShipping orderShipping = orderShippingService.getOrderShippingById(id);
        notFoundEntity(OrderShipping.class, orderShipping, id);

        return new OrderShippingDto(orderShipping);
    }

    private DeliveryAddress getAddressByShippingData(OrderShippingData orderShippingData) {
        State state = stateService.getStateById(orderShippingData.getState());
        notFoundEntity(State.class, state, orderShippingData.getState());

        DeliveryAddress address = new DeliveryAddress();
        address.setState(state);
        address.setCity(orderShippingData.getCity());
        address.setStreet(orderShippingData.getStreet());
        address.setNumber(orderShippingData.getNumber());

        return deliveryAddressService.save(address);
    }
}
