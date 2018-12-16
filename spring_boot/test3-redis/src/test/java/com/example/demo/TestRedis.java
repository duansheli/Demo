package com.example.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class TestRedis {
    private Jedis jedis;

    @Before
    public void setup() {
        // 连接redis服务器
        jedis = new Jedis("172.17.0.2", 6379);
        // 用密码登陆
        // jedis.auth("pwd");
    }

    /**
     * redis 操作字符串 增删改查
     */
    @Test
    public void test1_String() {
        String key = "count";
        jedis.set(key, "num1 ");
        System.out.println(jedis.get(key));

        // 追加
        jedis.append(key, "num2 ");
        System.out.println(jedis.get(key));

        // 删除
        jedis.del(key);
        System.out.println(jedis.get(key));

        // 设置多个键值对
        jedis.mset("name", "zs", "age", "11", "phone", "123");
        // 原子性的自增操作
        jedis.incr("age");
        System.out.println("----------------");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        System.out.println(jedis.get("phone"));

    }

    /**
     * redis操作Map
     */
    @Test
    public void test2_map() {
        String key = "map_k1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zs");
        map.put("age", "11");
        map.put("phone", "123");
        // 1. add 设置查询条件
        jedis.hmset(key, map);
        List<String> rsmap = jedis.hmget(key, "name", "phone");
        System.out.println(rsmap);

        // 2. 查询key对象的所有key_name
        System.out.println(jedis.hkeys(key));// 返回map对象中的所有key
        // 通过key_name查询key_value
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(key + ":" + jedis.hmget(key, next));
        }
        // 3. 查询 指定map中所有的key_value
        System.out.println("all ---- " + jedis.hvals(key));

        // 4. del 指定条件属性
        jedis.hdel(key, "age");
        System.out.println(jedis.hmget(key, "age"));

        // 查询指定key中数据长度
        System.out.println(jedis.hlen(key));
        // 查询指定key是否存在
        System.out.println(jedis.exists(key));

        jedis.del(key);
    }

    /**
     * jedis操作List
     */
    @Test
    public void test3_list() {
        String id = "list_k1";
        jedis.flushAll();

        // 从左到右添加三个数据
        jedis.lpush(id, "A");
        jedis.lpush(id, "B");
        jedis.lpush(id, "C");
        // 查询第1到3条数据
        System.out.println(jedis.lrange(id, 0, 2));

        jedis.del(id);
        jedis.rpush(id, "A");
        jedis.rpush(id, "B");
        jedis.rpush(id, "C");
        // 从第1查到最后1条数据
        System.out.println(jedis.lrange(id, 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void test4_set() {
        String id = "food";
        // 添加
        jedis.sadd(id, "apple");
        jedis.sadd(id, "lemon");
        jedis.sadd(id, "orange");
        jedis.sadd(id, "cherry");

        // 删除某个元素
        jedis.srem(id, "cherry");
        System.out.println("查询所有     " + jedis.smembers(id));
        System.out.println("判断是否存在某个元素     " + jedis.sismember(id, "lemon"));
        System.out.println("随机返回一个     " + jedis.srandmember(id));
        System.out.println("该集合元素个数     " + jedis.scard(id));
    }

    @Test
    public void test5_list_sort() throws InterruptedException {
        // jedis 排序
        String key = "sort_test";
        jedis.del(key);// 先清除数据，再加入数据进行测试
        jedis.rpush(key, "7");
        jedis.lpush(key, "3");
        jedis.lpush(key, "8");
        jedis.lpush(key, "5");
        jedis.lpush(key, "2");
        jedis.lpush(key, "9");

        System.out.println("所有数据" + jedis.lrange(key, 0, -1));
        System.out.println("对查询的数据排序 " + jedis.sort(key));// 默认会以数字排序
        System.out.println("原先的顺序不变 " + jedis.lrange(key, 0, -1));

        System.out.println("-------使用更多查询参数------------");
        jedis.del(key);//
        jedis.rpush(key, "D");
        jedis.lpush(key, "S");
        jedis.lpush(key, "A");
        jedis.lpush(key, "H");
        jedis.lpush(key, "P");
        jedis.lpush(key, "W");
        System.out.println(jedis.lrange(key, 0, -1));

        SortingParams sp = new SortingParams();
        sp.limit(0, 2) // 可用于分页查询
                .alpha()// 字符串排序
                .asc();// 倒序

        System.out.println(jedis.sort(key, sp));
        System.out.println(jedis.lrange(key, 0, -1));
    }

}