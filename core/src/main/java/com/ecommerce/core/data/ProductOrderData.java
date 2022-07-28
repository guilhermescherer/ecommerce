package com.ecommerce.core.data;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductOrderData {

    @NotNull
    private Long product;
    @NotNull
    private Integer amount;
}
