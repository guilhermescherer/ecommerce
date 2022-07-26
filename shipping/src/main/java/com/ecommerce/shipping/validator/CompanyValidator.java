package com.ecommerce.shipping.validator;

import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.common.exception.NotFoundExceptionHttp;

import static java.util.Objects.isNull;

public abstract class CompanyValidator {

    public static void notFoundCompanyToAddress(Object object, DeliveryAddress address) {
        if(isNull(object)) {
            String message = String.format("Not found Company to address [%s,%s - %s/%s]", address.getStreet(),
                    address.getNumber(), address.getCity(), address.getState().getName());
            throw new NotFoundExceptionHttp(message);
        }
    }
}
