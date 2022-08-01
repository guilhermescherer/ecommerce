package com.ecommerce.shipping.data;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShippingData {

    @NotNull
    private Long order;
    @NotNull
    private String state;
}
