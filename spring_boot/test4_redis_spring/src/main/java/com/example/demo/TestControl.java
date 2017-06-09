/**  
 * Project Name:ad2  
 * File Name:Hello.java  
 * Package Name:com.ff.control  
 * Date:2016年4月26日下午4:38:48  
 * Copyright (c) 2016, zhangxin All Rights Reserved.  
 *  
*/

package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl {
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate<String, Object> template;

    /**
     * 键值对保存 k : v
     */
    @RequestMapping("/a1")
    public String test1_kv() {
        String key = "userName";
        ValueOperations<String, Object> valueOperations = template.opsForValue();
        valueOperations.set(key, "peter");
        System.out.println(valueOperations.get(key));
        return "done";
    }

    @Resource(name = "redisTemplate")
    ListOperations<String, String> listOps;

    /**
     * list操作
     */
    @RequestMapping("/a2")
    public String test2_list() {
        String key = "test_list";
        template.delete(key);

        listOps.leftPush(key, "aa");
        listOps.leftPush(key, "bb");
        listOps.leftPush(key, "cc");

        List<String> list = listOps.range(key, 0, -1);

        System.out.println(list);
        return "done";
    }

    @RequestMapping("/a3")
    public String test3_list() {
        System.out.println("-----------------------");
        String key = "rest_list";

        return "done";
    }

    @Resource(name = "redisTemplate")
    HashOperations<String, Object, Object> opsForHash;

    /**  
    * 
    */
    @RequestMapping("/a4")
    public String test4_map() {
        String key = "test_map";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zs");
        map.put("age", "12");
        opsForHash.putAll(key, map);

        System.out.println(opsForHash.entries(key));
        return "done";
    }

    @Resource(name = "redisTemplate")
    SetOperations<String, Object> opsForSet;

    @RequestMapping("/a5")
    public String test5_set() {
        String key = "test_set";
        opsForSet.add(key, "dog");
        opsForSet.add(key, "cat");
        opsForSet.add(key, "pig");
        // 输出 set 集合
        System.out.println(opsForSet.members(key));
        return "done";
    }

    @Resource(name = "redisTemplate")
    ZSetOperations<String, Object> opsForZSet;

    @RequestMapping("/a6")
    public String test6_zset() {
        String key = "test_set";
        opsForZSet.add(key, "name_zs", 0);
        opsForZSet.add(key, "pwd_111", 1);
        opsForZSet.add(key, "phone_789456", 2);
        // 输出有序 set 集合
        System.out.println(opsForZSet.rangeByScore(key, 0, 2));
        return "done";
    }

}
