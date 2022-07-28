package com.ecommerce.core.model;

import com.ecommerce.core.model.state.ReceivedState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productsOrder;
    private BigDecimal price;
    @ManyToOne
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    private State state;

    public Order() {
        this.state = new ReceivedState();
    }
}
