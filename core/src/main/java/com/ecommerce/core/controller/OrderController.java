package com.ecommerce.core.controller;

import com.ecommerce.common.controller.BaseController;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.data.UpdateStateData;
import com.ecommerce.core.dto.OrderDto;
import com.ecommerce.core.facade.OrderFacade;
import com.ecommerce.core.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private final OrderFacade orderFacade;

    @Autowired
    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderData orderData, UriComponentsBuilder uriBuilder) {
        Order order = orderFacade.createOrder(orderData);

        URI uri = uriBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrderDto(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDto = new OrderDto(orderFacade.getOrderById(id));
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("/{id}/state")
    public ResponseEntity<?> updateState(@PathVariable Long id, @RequestParam("state") UpdateStateData updateSate) {
        orderFacade.updateState(id, updateSate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/port")
    public String infoPort(@Value("${local.server.port}") String port) {
        return String.format("Running in port [%s]", port);
    }
}
