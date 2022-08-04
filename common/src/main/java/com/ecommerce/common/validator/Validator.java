package com.ecommerce.common.validator;

import com.ecommerce.common.exception.NotFoundExceptionHttp;

import static java.util.Objects.isNull;

public abstract class Validator {

    public static void notFoundEntity(Class<?> clazz, Object object, Object id) {
        if(isNull(object)) {
            String message = String.format("Not found [%s] with id [%s]", clazz.getSimpleName(), id);
            throw new NotFoundExceptionHttp(message);
        }
    }
}
