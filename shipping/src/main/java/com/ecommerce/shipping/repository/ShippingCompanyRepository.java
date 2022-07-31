package com.ecommerce.shipping.repository;

import com.ecommerce.shipping.model.ShippingCompany;
import com.ecommerce.shipping.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long> {

    List<ShippingCompany> findShippingCompaniesByStates(List<State> states);
}
