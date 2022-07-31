package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.repository.ShippingCompanyRepository;
import com.ecommerce.shipping.service.ShippingService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
public class ShippingServiceImpl implements ShippingService {

    private final ShippingCompanyRepository shippingCompanyRepository;

    public ShippingServiceImpl(ShippingCompanyRepository shippingCompanyRepository) {
        this.shippingCompanyRepository = shippingCompanyRepository;
    }

    @Override
    public ShippingCompany getShippingCompanyByState(State state) {
        ShippingCompany shippingCompany = null;

        if(nonNull(state)) {
            List<ShippingCompany> shippingCompanies = shippingCompanyRepository.findShippingCompaniesByStates(singletonList(state));

            if(isNotEmpty(shippingCompanies)) {
                shippingCompany = shippingCompanies.stream()
                        .max(Comparator.comparing(ShippingCompany::getScore))
                        .orElse(null);
            }
        }

        return shippingCompany;
    }
}
