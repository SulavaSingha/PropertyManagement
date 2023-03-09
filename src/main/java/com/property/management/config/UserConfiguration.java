package com.property.management.config;

import com.property.management.service.UserService;
import com.property.management.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
