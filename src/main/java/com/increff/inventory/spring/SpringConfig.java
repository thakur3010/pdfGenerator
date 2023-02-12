package com.increff.inventory.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.increff.inventory")
@PropertySources({
        @PropertySource(value = "file:./app.properties",ignoreResourceNotFound = true) //
})

public class SpringConfig {


}

