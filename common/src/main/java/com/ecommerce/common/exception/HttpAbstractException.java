package com.ecommerce.common.exception;

public abstract class HttpAbstractException extends RuntimeException {

    public HttpAbstractException(String message) {
        super(message);
    }

    public abstract int getStatus();

    public abstract String getError();
}
