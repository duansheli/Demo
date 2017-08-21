package com.fluffy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:dubbo-demo-consumer.xml"})
public class ConfigXml {
    
}