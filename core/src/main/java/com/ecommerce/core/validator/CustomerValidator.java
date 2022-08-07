package com.ecommerce.core.validator;

import com.ecommerce.common.exception.NotFoundExceptionHttp;
import com.ecommerce.core.model.Customer;

public abstract class CustomerValidator {

    public static void throwNotFoundAddressInCustomer(Customer customer, Long id) {
        String message = String.format("Not found address with id [%s] in customer [%s]", id, customer.getId());
        throw new NotFoundExceptionHttp(message);
    }
}
