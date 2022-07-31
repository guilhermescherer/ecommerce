package com.ecommerce.shipping.controller;

import com.ecommerce.shipping.data.ShippingData;
import com.ecommerce.shipping.dto.ShippingDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @PostMapping
    public ShippingDto createShipping(@RequestBody @Valid ShippingData shippingData) {
        return new ShippingDto();
    }
}
