package com.ecommerce.core.action.order;

import com.ecommerce.core.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Address;
import com.ecommerce.core.process.OrderProcess;

import java.util.List;

import static com.ecommerce.core.validator.CustomerValidator.notFoundAddressInCustomer;

@Action
public class SetDeliveryAddressAction extends OrderProcess {

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        List<Address> addresses = orderBuilder.getCustomer().getAddresses();

        Address address = addresses.stream()
                .filter(a -> a.getId().equals(orderData.getAddress()))
                .findFirst()
                .orElse(null);

        notFoundAddressInCustomer(orderBuilder.getCustomer(), address, orderData.getAddress());

        orderBuilder.setAddress(address);

        return performNext(orderData, orderBuilder);
    }
}
