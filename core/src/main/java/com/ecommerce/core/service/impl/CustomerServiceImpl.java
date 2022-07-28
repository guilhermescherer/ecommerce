package com.ecommerce.core.service.impl;

import com.ecommerce.core.model.Customer;
import com.ecommerce.core.repository.CustomerRepository;
import com.ecommerce.core.service.CustomerService;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return isNull(id) ? null : customerRepository.findById(id).orElse(null);
    }
}
