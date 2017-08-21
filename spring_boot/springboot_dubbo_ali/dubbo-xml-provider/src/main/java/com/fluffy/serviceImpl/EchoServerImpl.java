package com.fluffy.serviceImpl;
import com.fluffy.service.EchoService;

public class EchoServerImpl implements EchoService {

    public String echo(String str) {
        System.out.println(str);
        return str + "-Impl";
    }
}