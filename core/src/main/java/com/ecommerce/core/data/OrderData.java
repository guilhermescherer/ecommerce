package com.ecommerce.core.data;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderData {

    @NotNull
    private Long customer;
    @NotNull
    private Long address;
    @NotNull
    private List<ProductOrderData> productsOrder;
}
