package com.ecommerce.common.controller;

import com.ecommerce.common.dto.ExceptionErrorDto;
import com.ecommerce.common.exception.HttpAbstractException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ExceptionErrorDto handleException(Exception ex) {
        ExceptionErrorDto exceptionErrorDto = new ExceptionErrorDto();
        exceptionErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionErrorDto.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        exceptionErrorDto.setMessage(ex.getLocalizedMessage());
        exceptionErrorDto.setTimestamp(LocalDateTime.now());
        return exceptionErrorDto;
    }

    @ExceptionHandler(HttpAbstractException.class)
    public ExceptionErrorDto handleHttpAbstractException(HttpAbstractException ex) {
        ExceptionErrorDto exceptionErrorDto = new ExceptionErrorDto();
        exceptionErrorDto.setStatus(ex.getStatus());
        exceptionErrorDto.setError(ex.getError());
        exceptionErrorDto.setMessage(ex.getLocalizedMessage());
        exceptionErrorDto.setTimestamp(LocalDateTime.now());
        return exceptionErrorDto;
    }
}
