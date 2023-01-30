package com.ecommerce.core.data;

import com.ecommerce.core.model.state.CollectedState;
import com.ecommerce.core.model.state.DeliveredState;
import com.ecommerce.core.model.state.ReceivedState;

import java.util.Arrays;

public enum UpdateOrderStateData {

    TO_COLLECTED(CollectedState.NAME),
    TO_RECEIVED(ReceivedState.NAME),
    TO_DELIVERED(DeliveredState.NAME);

    final String name;

    UpdateOrderStateData(String name) {
        this.name = name;
    }

    public static UpdateOrderStateData get(String name) {
        return Arrays.stream(values())
                .filter(v -> v.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid name to UpdateOrderStateData"));
    }

    public String getName() {
        return name;
    }
}
