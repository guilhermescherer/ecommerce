package com.ecommerce.core.action.order;

import com.ecommerce.common.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Customer;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import static com.ecommerce.common.validator.Validator.notFoundEntity;

@Action
@Order(1)
public class SetCustomerOrderAction extends OrderProcess {

    private static final Logger LOG = LoggerFactory.getLogger(SetCustomerOrderAction.class);

    private final CustomerService customerService;

    public SetCustomerOrderAction(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        Customer customer = customerService.getCustomerById(orderData.getCustomer());
        notFoundEntity(Customer.class, customer, orderData.getCustomer());

        orderBuilder.setCustomer(customer);

        LOG.info(String.format("Customer [%d] added to Order", customer.getId()));

        return orderBuilder;
    }
}
