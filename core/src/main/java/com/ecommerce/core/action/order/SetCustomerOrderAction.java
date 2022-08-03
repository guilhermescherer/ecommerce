package com.ecommerce.core.action.order;

import com.ecommerce.core.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Customer;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.CustomerService;
import org.springframework.core.annotation.Order;

import static com.ecommerce.common.validator.Validator.notFoundEntity;

@Action
@Order(1)
public class SetCustomerOrderAction extends OrderProcess {

    private final CustomerService customerService;

    public SetCustomerOrderAction(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        Customer customer = customerService.getCustomerById(orderData.getCustomer());
        notFoundEntity(Customer.class, customer, orderData.getCustomer());

        orderBuilder.setCustomer(customer);

        return performNext(orderData, orderBuilder);
    }
}
