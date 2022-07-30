package com.ecommerce.core.validator;

import com.ecommerce.core.exception.NotFoundException;

import static java.util.Objects.isNull;

public abstract class Validator {

    public static void notFound(Class<?> clazz, Object object, Long id) {
        if(isNull(object)) {
            String message = String.format("Not found [%s] with id [%s]", clazz.getSimpleName(), id);
            throw new NotFoundException(message);
        }
    }
}
