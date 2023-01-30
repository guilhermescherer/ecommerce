package com.ecommerce.core.data;

import java.util.Arrays;

public enum UpdateStateData {

    COLLECTED("toCollected"),
    RECEIVED("toReceived"),
    DELIVERED("toDelivered");

    final String methodName;

    UpdateStateData(String methodName) {
        this.methodName = methodName;
    }

    public static UpdateStateData get(String state) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(state))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid name to UpdateStateData"));
    }

    public String getMethodName() {
        return methodName;
    }
}
