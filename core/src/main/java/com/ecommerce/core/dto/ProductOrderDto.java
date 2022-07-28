package com.ecommerce.core.dto;

import com.ecommerce.core.model.ProductOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductOrderDto {

    private Long id;
    private ProductDto product;
    private BigDecimal price;
    private Integer amount;
    public ProductOrderDto(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.product = new ProductDto(productOrder.getProduct());
        this.price = productOrder.getPrice();
        this.amount = productOrder.getAmount();
    }
}
