package com.ecommerce.core.model;

import com.ecommerce.core.exception.OrderSituationException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public abstract class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void toReceived(Order order)  {
        throw new OrderSituationException("Order cannot be received");
    }

    public abstract String getName();
}
