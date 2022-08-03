package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.DeliveryAddress;
import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.repository.ShippingCompanyRepository;
import com.ecommerce.shipping.service.ShippingCompanyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
public class ShippingCompanyServiceImpl implements ShippingCompanyService {

    private final ShippingCompanyRepository shippingCompanyRepository;

    public ShippingCompanyServiceImpl(ShippingCompanyRepository shippingCompanyRepository) {
        this.shippingCompanyRepository = shippingCompanyRepository;
    }

    @Override
    public ShippingCompany getShippingCompanyByAddress(DeliveryAddress address) {
        ShippingCompany shippingCompany = null;

        if(nonNull(address) && nonNull(address.getState())) {
            List<ShippingCompany> shippingCompanies = shippingCompanyRepository.findShippingCompanyByStates(address.getState());

            if(isNotEmpty(shippingCompanies)) {
                shippingCompany = shippingCompanies.stream()
                        .max(Comparator.comparing(ShippingCompany::getScore))
                        .orElse(null);
            }
        }

        return shippingCompany;
    }

    @Override
    public BigDecimal getShippingPriceByAddress(ShippingCompany company, DeliveryAddress address) {
        BigDecimal price = null;

        if(nonNull(company) && nonNull(address)) {
            price = BigDecimal.TEN.multiply(BigDecimal.valueOf(company.getId()));
        }

        return price;
    }
}
