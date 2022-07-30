package com.ecommerce.core.model.state;

import com.ecommerce.core.model.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("ReceivedState")
public class ReceivedState extends State {

    private static final String NAME = "Received";

    public ReceivedState() {}

    @Override
    public String getName() {
        return NAME;
    }
}
