package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.repository.ShippingCompanyRepository;
import com.ecommerce.shipping.service.ShippingCompanyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
public class ShippingCompanyServiceImpl implements ShippingCompanyService {

    private final ShippingCompanyRepository shippingCompanyRepository;

    public ShippingCompanyServiceImpl(ShippingCompanyRepository shippingCompanyRepository) {
        this.shippingCompanyRepository = shippingCompanyRepository;
    }

    @Override
    public ShippingCompany getShippingCompanyByState(State state) {
        ShippingCompany shippingCompany = null;

        if(nonNull(state)) {
            List<ShippingCompany> shippingCompanies = shippingCompanyRepository.findShippingCompanyByStates(state);

            if(isNotEmpty(shippingCompanies)) {
                shippingCompany = shippingCompanies.stream()
                        .max(Comparator.comparing(ShippingCompany::getScore))
                        .orElse(null);
            }
        }

        return shippingCompany;
    }

    @Override
    public BigDecimal getShippingPriceByState(ShippingCompany company, State state) {
        BigDecimal price = null;

        if(nonNull(company) && nonNull(state)) {
            price = BigDecimal.TEN.multiply(BigDecimal.valueOf(company.getId()));
        }

        return price;
    }
}
