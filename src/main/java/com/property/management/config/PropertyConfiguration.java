package com.property.management.config;

import com.property.management.service.PropertyService;
import com.property.management.service.impl.PropertyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfiguration {
    @Bean
    public PropertyService propertyService(){
        return new PropertyServiceImpl();
    }

}
