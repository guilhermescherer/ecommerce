package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionHttp extends HttpAbstractException {

    public NotFoundExceptionHttp(String message) {
        super(message);
    }

    @Override
    public int getStatus() {
        return HttpStatus.NOT_FOUND.value();
    }

    @Override
    public String getError() {
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }
}
