package com.ecommerce.core.model;

import com.ecommerce.core.builder.OrderBuilder;
import com.ecommerce.core.model.state.ReceivedState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long shipping;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productsOrder;
    private BigDecimal price;
    @ManyToOne
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    private State state;
    @ManyToOne
    private Address address;

    public Order() {
        this.state = new ReceivedState();
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }
}
