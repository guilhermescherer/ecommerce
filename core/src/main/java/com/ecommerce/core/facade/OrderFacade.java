package com.ecommerce.core.facade;

import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.data.UpdateOrderStateTypeData;
import com.ecommerce.core.model.Order;

public interface OrderFacade {

    Order createOrder(OrderData orderData);

    Order getOrderById(Long id);

    void orderCollected(Long id, UpdateOrderStateTypeData type);
}
