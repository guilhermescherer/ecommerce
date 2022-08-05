package com.ecommerce.shipping.data;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OrderShippingData {

    @NotNull @NotEmpty
    private String state;
    @NotNull @NotEmpty
    private String city;
    @NotNull @NotEmpty
    private String street;
    @NotNull
    private Integer number;
}
