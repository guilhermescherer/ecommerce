package com.ecommerce.core.validator;

import com.ecommerce.common.exception.NotFoundException;
import com.ecommerce.core.model.Address;
import com.ecommerce.core.model.Customer;

import static java.util.Objects.isNull;

public abstract class CustomerValidator {

    public static void notFoundAddressInCustomer(Customer customer, Address address, Long id) {
        if(isNull(address)) {
            String message = String.format("Not found address with id [%s] in customer [%s]", id, customer.getId());
            throw new NotFoundException(message);
        }
    }
}
