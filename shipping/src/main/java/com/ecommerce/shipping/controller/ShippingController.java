package com.ecommerce.shipping.controller;

import com.ecommerce.shipping.data.ShippingData;
import com.ecommerce.shipping.dto.ShippingDto;
import com.ecommerce.shipping.facade.ShippingFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingFacade shippingFacade;

    public ShippingController(ShippingFacade shippingFacade) {
        this.shippingFacade = shippingFacade;
    }

    @PostMapping
    public ResponseEntity<ShippingDto> createShipping(@RequestBody @Valid ShippingData shippingData, UriComponentsBuilder uriBuilder) {
        ShippingDto shippingDto = shippingFacade.createShipping(shippingData);

        URI uri = uriBuilder.path("/shipping/{id}").buildAndExpand(shippingDto.getId()).toUri();
        return ResponseEntity.created(uri).body(shippingDto);
    }
}
