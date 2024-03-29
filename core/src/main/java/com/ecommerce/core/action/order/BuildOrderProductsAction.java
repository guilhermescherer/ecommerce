package com.ecommerce.core.action.order;

import com.ecommerce.common.annotation.Action;
import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.data.OrderData;
import com.ecommerce.core.model.Product;
import com.ecommerce.core.model.ProductOrder;
import com.ecommerce.core.process.OrderProcess;
import com.ecommerce.core.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.common.validator.Validator.notFoundEntity;
import static com.ecommerce.core.validator.ProductValidator.verifyProductStock;

@Action
@Order(3)
public class BuildOrderProductsAction extends OrderProcess {

    private static final Logger LOG = LoggerFactory.getLogger(BuildOrderProductsAction.class);

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
                    notFoundEntity(Product.class, product, po.getProduct());
                    verifyProductStock(product, po.getAmount());

                    ProductOrder productOrder = new ProductOrder();
                    productOrder.setProduct(product);
                    productOrder.setAmount(po.getAmount());

                    BigDecimal price = getOrderPrice(po.getAmount(), product);
                    productOrder.setPrice(price);

                    productsOrder.add(productOrder);

                    String message = String.format("Product [%d] with amount [%d] added to Order", product.getId(), po.getAmount());
                    LOG.info(message);
                });

        orderBuilder.withProductsOrder(productsOrder);

        return orderBuilder;
    }

    private static BigDecimal getOrderPrice(Integer amount, Product product) {
        return product.getPrice().multiply(new BigDecimal(amount));
    }
}
