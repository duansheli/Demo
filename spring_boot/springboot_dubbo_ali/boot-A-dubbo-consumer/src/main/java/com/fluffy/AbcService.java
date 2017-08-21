package com.fluffy;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fluffy.service.EchoService;

@Component
public class AbcService {
    @Reference(version = "2.0")
    public EchoService echoService;
}
