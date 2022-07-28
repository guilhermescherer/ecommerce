package com.ecommerce.core.validator;

import com.ecommerce.core.exception.NotFoundException;
import com.ecommerce.core.model.Product;

import static java.util.Objects.isNull;

public interface ProductValidator {

    static void productNotFound(Product product, Long id) {
        if(isNull(product)) {
            String message = String.format("Not found product with id [%s]", id);
            throw new NotFoundException(message);
        }
    }

    static void verifyProductStock(Product product, Integer amount) {
        if(product.getStock() < amount) {
            String message = String.format("Stock for product [%s] is invalid for this purchase", product.getId());
            throw new NotFoundException(message);
        }
    }
}
