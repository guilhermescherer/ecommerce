package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.DeliveryAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class DeliveryAddressDto {

    private Long id;
    private StateDto state;
    private String city;
    private String street;
    private Integer number;

    public DeliveryAddressDto(DeliveryAddress deliveryAddress) {
        BeanUtils.copyProperties(deliveryAddress, this);
        this.state = new StateDto(deliveryAddress.getState());
    }
}
