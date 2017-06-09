package com.example.demo2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@ImportResource(locations = { "classpath:xml_conf/application-conf.xml" })
@EnableRedisRepositories
public class RedisConfig {

}