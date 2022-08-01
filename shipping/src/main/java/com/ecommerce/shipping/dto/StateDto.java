package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDto {
    private String name;

    public StateDto(State state) {
        this.name = state.getName();
    }
}
