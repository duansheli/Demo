package com.example.demo3.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class HomeAddress {

    String address;
    
    public HomeAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}