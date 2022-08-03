package com.ecommerce.shipping.builder;

import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.shipping.model.OrderShipping;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.service.OrderShippingService;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderShippingBuilder {

    private Long order;
    private BigDecimal price;
    private ShippingCompany shippingCompany;
    private DeliveryAddress deliveryAddress;

    public OrderShipping build(OrderShippingService orderShippingService) {
        OrderShipping orderShipping = new OrderShipping();

        orderShipping.setOrder(this.order);
        orderShipping.setPrice(this.price);
        orderShipping.setShippingCompany(this.shippingCompany);
        orderShipping.setDeliveryAddress(this.deliveryAddress);

        return orderShippingService.save(orderShipping);
    }
}
