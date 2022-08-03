package com.ecommerce.shipping.configuration;

import com.ecommerce.shipping.dto.ExceptionErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ExceptionErrorDto handleException(Exception ex) {
        ExceptionErrorDto exceptionErrorDto = new ExceptionErrorDto();
        exceptionErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionErrorDto.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        exceptionErrorDto.setMessage(ex.getLocalizedMessage());
        exceptionErrorDto.setTimestamp(LocalDateTime.now());
        return exceptionErrorDto;
    }
}
