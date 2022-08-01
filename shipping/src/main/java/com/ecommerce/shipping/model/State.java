package com.ecommerce.shipping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class State {

    @Id
    private String name;
    @ManyToMany(mappedBy = "states")
    private List<ShippingCompany> shippingCompanies;
}
