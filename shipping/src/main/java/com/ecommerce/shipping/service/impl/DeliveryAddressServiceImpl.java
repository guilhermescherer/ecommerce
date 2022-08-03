package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.shipping.repository.DeliveryAddressRepository;
import com.ecommerce.shipping.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressServiceImpl(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    @Override
    public DeliveryAddress save(DeliveryAddress deliveryAddress) {
        return deliveryAddressRepository.save(deliveryAddress);
    }
}
