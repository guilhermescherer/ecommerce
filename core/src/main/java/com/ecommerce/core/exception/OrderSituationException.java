package com.ecommerce.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class OrderSituationException extends RuntimeException {
    public OrderSituationException(String message) {
        super(message);
    }
}
