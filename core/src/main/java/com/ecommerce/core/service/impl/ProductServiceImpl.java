package com.ecommerce.core.service.impl;

import com.ecommerce.core.model.Product;
import com.ecommerce.core.repository.ProductRepository;
import com.ecommerce.core.service.ProductService;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return isNull(id) ? null : productRepository.findById(id).orElse(null);
    }
}
