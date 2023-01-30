package com.ecommerce.core.converter;

import com.ecommerce.core.data.UpdateOrderStateData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderStateDataEnumConverter implements Converter<String, UpdateOrderStateData> {

    @Override
    public UpdateOrderStateData convert(String source) {
        return UpdateOrderStateData.get(source);
    }
}
