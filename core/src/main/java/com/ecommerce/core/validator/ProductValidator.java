package com.ecommerce.core.validator;

import com.ecommerce.common.exception.NotFoundExceptionHttp;
import com.ecommerce.core.model.Product;

public abstract class ProductValidator {

    public static void verifyProductStock(Product product, Integer amount) {
        if(product.getStock() < amount) {
            String message = String.format("Stock for product [%s] is invalid for this purchase", product.getId());
            throw new NotFoundExceptionHttp(message);
        }
    }
}
