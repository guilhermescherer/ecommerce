package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.State;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class StateDto {

    private String name;

    public StateDto(State state) {
        BeanUtils.copyProperties(state, this);
    }
}
