package com.fluffy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource("classpath:global.properties")
@Data
public class GlobalProperties {

    @Value("${thread-pool}")
    private int threadPool;

    @Value("${email}")
    private String email;

}