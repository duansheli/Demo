package com.fluffy.serviceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import com.fluffy.service.EchoService;


@Service(version="2.0")
public class EchoServerImpl implements EchoService {

    public String echo(String str) {
        System.out.println(str);
        return str+"---8899";
    }
}