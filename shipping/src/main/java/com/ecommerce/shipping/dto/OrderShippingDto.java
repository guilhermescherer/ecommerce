package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.OrderShipping;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Getter
@Setter
public class OrderShippingDto {

    private Long id;
    private Long order;
    private BigDecimal price;
    private ShippingCompanyDto shippingCompany;
    private DeliveryAddressDto deliveryAddress;
    private List<HistoryShippingDto> history;

    public OrderShippingDto(OrderShipping orderShipping) {
        this.id = orderShipping.getId();
        this.order = orderShipping.getOrder();
        this.price = orderShipping.getPrice();
        this.shippingCompany = new ShippingCompanyDto(orderShipping.getShippingCompany());
        this.deliveryAddress = new DeliveryAddressDto(orderShipping.getDeliveryAddress());
        this.history = isNotEmpty(orderShipping.getHistory()) ? orderShipping.getHistory().stream().map(HistoryShippingDto::new).toList() : null;
    }
}
