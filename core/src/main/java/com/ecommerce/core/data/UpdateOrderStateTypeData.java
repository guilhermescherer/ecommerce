package com.ecommerce.core.data;

import java.util.Arrays;

public enum UpdateOrderStateTypeData {

    TO_COLLECTED("collected"),
    TO_DELIVERED("delivered");

    final String name;

    UpdateOrderStateTypeData(String name) {
        this.name = name;
    }

    public static UpdateOrderStateTypeData get(String name) {
        return Arrays.stream(values())
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid name to UpdateOrderStateTypeData"));
    }

    public String getName() {
        return name;
    }
}
