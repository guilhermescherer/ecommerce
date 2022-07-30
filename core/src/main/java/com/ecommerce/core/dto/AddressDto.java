package com.ecommerce.core.dto;

import com.ecommerce.core.model.Address;
import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String state;
    private String city;
    private String street;
    private String number;
    public AddressDto(Address address) {
        this.id = address.getId();
        this.state = address.getState().name();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.number = address.getNumber();
    }
}
