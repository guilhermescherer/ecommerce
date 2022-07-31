package com.ecommerce.core.configuration.bean;

import com.ecommerce.core.process.OrderProcess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderProcessBeanConfiguration {

    private final List<OrderProcess> orderProcess;

    public OrderProcessBeanConfiguration(List<OrderProcess> orderProcess) {
        this.orderProcess = orderProcess;
    }

    @Bean
    public OrderProcess orderProcess() {
        for (int i = 0; i < orderProcess.size(); i++) {
            if((i + 1) < orderProcess.size()) {
                orderProcess.get(i).linkWith(orderProcess.get(i + 1));
            }
        }

        return orderProcess.stream()
                .findFirst()
                .orElse(null);
    }
}
