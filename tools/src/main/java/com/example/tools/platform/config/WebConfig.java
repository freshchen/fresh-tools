package com.example.tools.platform.config;

import com.example.tools.platform.formatter.CustomFormatterRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author darcy
 * @since 2020/06/13
 **/
@Configuration
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        new CustomFormatterRegistrar().registerFormatters(registry);
    }
}
