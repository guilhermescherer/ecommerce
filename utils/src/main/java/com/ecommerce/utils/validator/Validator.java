package com.ecommerce.utils.validator;

import com.ecommerce.utils.exception.NotFoundException;

import static java.util.Objects.isNull;

public abstract class Validator {

    public static void notFoundEntity(Class<?> clazz, Object object, Object id) {
        if(isNull(object)) {
            String message = String.format("Not found [%s] with id [%s]", clazz.getSimpleName(), id);
            throw new NotFoundException(message);
        }
    }
}
