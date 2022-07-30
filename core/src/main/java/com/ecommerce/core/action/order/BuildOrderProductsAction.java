package com.ecommerce.core.action.order;

import com.ecommerce.core.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Product;
import com.ecommerce.core.model.ProductOrder;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.core.validator.ProductValidator.verifyProductStock;
import static com.ecommerce.core.validator.Validator.notFound;

@Action
public class BuildOrderProductsAction extends OrderProcess {

    private final ProductService productService;

    public BuildOrderProductsAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public OrderBuilder perform(OrderData orderData, OrderBuilder orderBuilder) {
        List<ProductOrder> productsOrder = new ArrayList<>();

        orderData.getProductsOrder()
                .forEach(po -> {
                    Product product = productService.getProductById(po.getProduct());
                    notFound(Product.class, product, po.getProduct());
                    verifyProductStock(product, po.getAmount());

                    ProductOrder productOrder = new ProductOrder();
                    productOrder.setProduct(product);
                    productOrder.setAmount(po.getAmount());

                    BigDecimal price = getOrderPrice(po.getAmount(), product);
                    productOrder.setPrice(price);

                    productsOrder.add(productOrder);
                });

        orderBuilder.setProductsOrder(productsOrder);

        return performNext(orderData, orderBuilder);
    }

    private static BigDecimal getOrderPrice(Integer amount, Product product) {
        return product.getPrice().multiply(new BigDecimal(amount));
    }
}
