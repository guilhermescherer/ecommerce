package com.ecommerce.core.dto;

import com.ecommerce.core.model.State;
import lombok.Data;

@Data
public class StateDto {

    private final String name;

    public StateDto(State state) {
        this.name = state.getClassName();
    }
}
