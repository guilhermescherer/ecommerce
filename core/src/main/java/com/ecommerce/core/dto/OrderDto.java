package com.ecommerce.core.dto;

import com.ecommerce.core.model.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private BigDecimal price;
    private CustomerDto customer;
    private StateDto state;
    private List<ProductOrderDto> productsOrder;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.customer = new CustomerDto(order.getCustomer());
        this.state = new StateDto(order.getState());
        this.productsOrder = order.getProductsOrder().stream().map(ProductOrderDto::new).toList();
    }
}
