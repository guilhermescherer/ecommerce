package com.ecommerce.core.validator;

import com.ecommerce.core.exception.NotFoundException;
import com.ecommerce.core.model.Customer;

import static java.util.Objects.isNull;

public interface CustomerValidator {

    static void customerNotFound(Customer customer, Long id) {
        if(isNull(customer)) {
            String message = String.format("Not found customer with id [%s]", id);
            throw new NotFoundException(message);
        }
    }
}
