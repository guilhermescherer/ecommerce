package com.ecommerce.core.controller;

import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.dto.OrderDto;
import com.ecommerce.core.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderFacade orderFacade;

    @Autowired
    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody @Valid OrderData orderData) {
        return orderFacade.createOrder(orderData);
    }
}
