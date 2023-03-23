package com.example.introtospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration // Java class-based configuration
public class MyConfigurationClass {

    @Bean
    public Car car() {
        return new Car("Camry", "Toyota", 2005);
    }

}
