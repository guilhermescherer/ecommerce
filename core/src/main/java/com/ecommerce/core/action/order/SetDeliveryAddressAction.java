package com.ecommerce.core.action.order;

import com.ecommerce.common.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Address;
import com.ecommerce.core.process.OrderProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.util.List;

import static com.ecommerce.core.validator.CustomerValidator.throwNotFoundAddressInCustomer;

@Action
@Order(2)
public class SetDeliveryAddressAction extends OrderProcess {

    private static final Logger LOG = LoggerFactory.getLogger(SetDeliveryAddressAction.class);

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        List<Address> addresses = orderBuilder.getCustomer().getAddresses();

        addresses.stream()
                .filter(a -> a.getId().equals(orderData.getAddress()))
                .findFirst()
                .ifPresentOrElse(
                        (address) -> {
                            orderBuilder.setAddress(address);
                            LOG.info(String.format("Address [%d] added to Order", address.getId()));
                        },
                        () -> throwNotFoundAddressInCustomer(orderBuilder.getCustomer(), orderData.getAddress()));

        return orderBuilder;
    }
}
