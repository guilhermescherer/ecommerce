package com.ecommerce.core.model.state;

import com.ecommerce.core.model.State;

public class ReceivedState extends State {

    private static final String NAME = "Received";

    @Override
    public String getName() {
        return NAME;
    }
}
