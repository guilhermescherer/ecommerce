package com.ecommerce.core.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionErrorDto {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
}
