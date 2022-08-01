package com.ecommerce.shipping.validator;

import com.ecommerce.shipping.model.State;
import com.ecommerce.utils.exception.NotFoundException;

import static java.util.Objects.isNull;

public abstract class Validator {

    public static void notFoundCompanyToState(Object object, State state) {
        if(isNull(object)) {
            String message = String.format("Not found Company to state [%s]", state.getName());
            throw new NotFoundException(message);
        }
    }
}
