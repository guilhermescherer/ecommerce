package com.ecommerce.shipping.dto;

import com.ecommerce.shipping.model.HistoryShipping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HistoryShippingDto {

    private Long id;
    private String description;

    public HistoryShippingDto(HistoryShipping historyShipping) {
        this.id = historyShipping.getId();
        this.description = historyShipping.getDescription();
    }
}
