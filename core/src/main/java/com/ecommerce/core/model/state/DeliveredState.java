package com.ecommerce.core.model.state;

import com.ecommerce.core.model.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("DeliveredState")
public class DeliveredState extends State {

    private static final String NAME = "Delivered";

    @Override
    public String getClassName() {
        return NAME;
    }
}
