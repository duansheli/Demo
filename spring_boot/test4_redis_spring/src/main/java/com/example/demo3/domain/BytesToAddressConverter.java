package com.example.demo3.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

@ReadingConverter
public class BytesToAddressConverter implements Converter<byte[], HomeAddress> {

    private final Jackson2JsonRedisSerializer<HomeAddress> serializer;

    public BytesToAddressConverter() {
        serializer = new Jackson2JsonRedisSerializer<HomeAddress>(HomeAddress.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public HomeAddress convert(byte[] value) {
        return serializer.deserialize(value);
    }
}