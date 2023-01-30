package com.ecommerce.core.converter;

import com.ecommerce.core.data.UpdateStateData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderStateDataEnumConverter implements Converter<String, UpdateStateData> {

    @Override
    public UpdateStateData convert(String source) {
        return UpdateStateData.get(source);
    }
}
