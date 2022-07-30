package com.ecommerce.core.configuration.action;

import com.ecommerce.core.action.order.SetDeliveryAddressAction;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.action.order.SetCustomerOrderAction;
import com.ecommerce.core.action.order.CalculateOrderPriceAction;
import com.ecommerce.core.action.order.BuildOrderProductsAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderProcessBeanConfiguration {

    private final SetCustomerOrderAction setCustomerOrder;
    private final BuildOrderProductsAction buildOrderProducts;
    private final CalculateOrderPriceAction calculateOrderPrice;
    private final SetDeliveryAddressAction setDeliveryAddress;

    public OrderProcessBeanConfiguration(SetCustomerOrderAction setCustomerOrder, BuildOrderProductsAction buildOrderProducts, CalculateOrderPriceAction calculateOrderPrice, SetDeliveryAddressAction setDeliveryAddress) {
        this.setCustomerOrder = setCustomerOrder;
        this.buildOrderProducts = buildOrderProducts;
        this.calculateOrderPrice = calculateOrderPrice;
        this.setDeliveryAddress = setDeliveryAddress;
    }

    @Bean
    public OrderProcess orderProcess() {
        setCustomerOrder
                .linkWith(setDeliveryAddress)
                .linkWith(buildOrderProducts)
                .linkWith(calculateOrderPrice);

        return setCustomerOrder;
    }
}
