/**  
 * Project Name:ad2  
 * File Name:Hello.java  
 * Package Name:com.ff.control  
 * Date:2016年4月26日下午4:38:48  
 * Copyright (c) 2016, zhangxin All Rights Reserved.  
 *  
*/

package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.domain.Person;
import com.example.demo2.domain.PersonRepository;
import com.example.demo3.domain.HomeAddress;

@RestController
public class TestControl2 {
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate<String, Object> template;

    @Autowired
    PersonRepository repository;

    /**
     * 使用repository将对象保存到redis中 . 
     * repository要求redis版本最低为2.8.0
     */
    @RequestMapping("/b1")
    public String test1_kv() {
        String id = "p002";
        Person p = new Person(id, "张", "三");
        // 设置过期时间
        p.expiration = 1L;
        p.homeAddress = new HomeAddress("人民广场");
        System.out.println(p);

        // 1. 保存
        repository.save(p);
        // 2. 查询
        Person person = repository.findOne(id);

        System.out.println(person);
        return "done";
    }

}
