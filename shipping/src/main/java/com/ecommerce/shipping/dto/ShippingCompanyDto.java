package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.ShippingCompany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingCompanyDto {

    private Long id;
    private String name;
    private Integer score;

    public ShippingCompanyDto(ShippingCompany shippingCompany) {
        this.id = shippingCompany.getId();
        this.name = shippingCompany.getName();
        this.score = shippingCompany.getScore();
    }
}
