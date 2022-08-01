package com.ecommerce.shipping.repository;

import com.ecommerce.shipping.model.OrderShipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderShippingRepository extends JpaRepository<OrderShipping, Long> {
}
