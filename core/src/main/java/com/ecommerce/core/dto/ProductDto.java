package com.ecommerce.core.dto;

import com.ecommerce.core.model.Product;
import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
