package com.example.demo3.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

@WritingConverter
public class AddressToBytesConverter implements Converter<HomeAddress, byte[]> {

    private final Jackson2JsonRedisSerializer<HomeAddress> serializer;

    public AddressToBytesConverter() {
        serializer = new Jackson2JsonRedisSerializer<HomeAddress>(HomeAddress.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(HomeAddress value) {
        return serializer.serialize(value);
    }
}
