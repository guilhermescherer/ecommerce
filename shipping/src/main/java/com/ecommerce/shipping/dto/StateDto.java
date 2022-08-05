package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class StateDto {

    private String name;

    public StateDto(State state) {
        BeanUtils.copyProperties(state, this);
    }
}
