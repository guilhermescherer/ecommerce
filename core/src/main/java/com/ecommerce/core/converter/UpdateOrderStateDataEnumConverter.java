package com.ecommerce.core.converter;

import com.ecommerce.core.data.UpdateOrderStateTypeData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderStateDataEnumConverter implements Converter<String, UpdateOrderStateTypeData> {

    @Override
    public UpdateOrderStateTypeData convert(String source) {
        return UpdateOrderStateTypeData.get(source);
    }
}
