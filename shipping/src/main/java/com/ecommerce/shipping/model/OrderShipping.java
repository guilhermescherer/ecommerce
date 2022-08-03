package com.ecommerce.shipping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`order`")
    private Long order;
    private BigDecimal price;
    @ManyToOne
    private ShippingCompany shippingCompany;
    @OneToOne
    private DeliveryAddress deliveryAddress;
    @OneToMany(mappedBy = "orderShipping", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistoryShipping> history;
}
