package com.example.tools.platform.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * @author darcy
 * @since 2020/06/27
 **/
public class CustomFormatterRegistrar implements FormatterRegistrar {
    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new CustomEnumConverterFactory("name", "value"));
    }
}
