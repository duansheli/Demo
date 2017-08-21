package com.fluffy.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:spring-demo.xml"})
public class ConfigXml {
    
}