package com.ecommerce.core.builder;

import com.ecommerce.core.model.Customer;
import com.ecommerce.core.model.Order;
import com.ecommerce.core.model.ProductOrder;
import com.ecommerce.core.service.OrderService;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderBuilder {

    private Customer customer;
    private List<ProductOrder> productsOrder;
    private BigDecimal price;

    public Order build(OrderService orderService) {
        Order order = new Order();

        order.setCustomer(this.customer);
        order.setProductsOrder(this.productsOrder);
        order.setPrice(this.price);

        return orderService.save(order);
    }
}
