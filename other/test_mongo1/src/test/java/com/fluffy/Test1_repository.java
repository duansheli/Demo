package com.fluffy;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fluffy.dao.UserRepository;
import com.fluffy.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1_repository {

    @Autowired
    private UserRepository userRepository;
    
    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test1() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

    }
    
    @Test
    public void test2() throws Exception {
        // 创建三个User，并验证User总数
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        
        // 删除一个User，再验证User总数
        User u = userRepository.findByUsernameLike("mama");
        System.out.println("like is : " + u.getUsername());
        
        List<User> list = userRepository.findByUsernameNotLike("mama");
        System.out.println("not like is : " + list.get(0).getUsername());
        
    }


}
