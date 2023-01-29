package com.ecommerce.core.model;

import com.ecommerce.core.exception.OrderStateException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "state_type", discriminatorType = DiscriminatorType.STRING)
public abstract class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void toCollected(Order order) {
        throw new OrderStateException("Order cannot be collected");
    }

    public void toDelivered(Order order) {
        throw new OrderStateException("Order cannot be delivered");
    }

    public abstract String getClassName();
}


