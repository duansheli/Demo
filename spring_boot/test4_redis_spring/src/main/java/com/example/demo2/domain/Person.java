package com.example.demo2.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import com.example.demo3.domain.HomeAddress;

@RedisHash("persons")
public class Person {

    @Id
    String id;
    String firstname;
    String lastname;
    public HomeAddress homeAddress;
    
    @TimeToLive
    public Long expiration;

    public Person(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}