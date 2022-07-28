package com.ecommerce.core.dto;

import com.ecommerce.core.model.Customer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CustomerDto {

    private Long id;
    private String name;

    public CustomerDto(Customer customer) {
        BeanUtils.copyProperties(customer, this);
    }
}
