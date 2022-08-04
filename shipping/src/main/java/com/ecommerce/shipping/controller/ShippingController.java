package com.ecommerce.shipping.controller;

import com.ecommerce.common.controller.BaseController;
import com.ecommerce.shipping.data.OrderShippingData;
import com.ecommerce.shipping.dto.OrderShippingDto;
import com.ecommerce.shipping.facade.OrderShippingFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/shipping")
public class ShippingController extends BaseController {

    private final OrderShippingFacade orderShippingFacade;

    public ShippingController(OrderShippingFacade orderShippingFacade) {
        this.orderShippingFacade = orderShippingFacade;
    }

    @PostMapping
    public ResponseEntity<OrderShippingDto> createOrderShipping(@RequestBody @Valid OrderShippingData shippingData, UriComponentsBuilder uriBuilder) {
        OrderShippingDto orderShippingDto = orderShippingFacade.createOrderShipping(shippingData);

        URI uri = uriBuilder.path("/shipping/{id}").buildAndExpand(orderShippingDto.getId()).toUri();
        return ResponseEntity.created(uri).body(orderShippingDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderShippingDto> getOrderShippingById(@PathVariable Long id) {
        return ResponseEntity.ok(orderShippingFacade.getOrderShippingById(id));
    }
}
