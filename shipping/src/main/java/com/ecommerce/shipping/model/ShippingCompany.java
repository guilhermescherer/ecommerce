package com.ecommerce.shipping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "company")
@Getter
@Setter
public class ShippingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "state_company",
            joinColumns = {@JoinColumn(name = "fk_company")},
            inverseJoinColumns = {@JoinColumn(name = "fk_state")})
    private List<State> states;
    @OneToMany(mappedBy = "shippingCompany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderShipping> ordersShipping;
    private Integer score;
}
