package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao_cluster.GoodsSnapshotMapper;
import com.example.demo.dao_master.TbUserMapper;
import com.example.demo.domain_cluster.GoodsSnapshot;
import com.example.demo.domain_master.TbUser;

@RestController
public class HelloController {
    @Autowired
    TbUserMapper tum;

    @RequestMapping("/master")
    public String master() {
        System.out.println(tum.selectByPrimaryKey(123));
        System.out.println("insert now");
        TbUser u1 = new TbUser();
        u1.setId(12);
        u1.setUname("zs");
        u1.setPwd("12");
        tum.insert(u1);
        System.out.println(u1.getId());
        return "Hello World master";
    }

    @Autowired
    GoodsSnapshotMapper gsm;

    @RequestMapping("/cluster")
    public String cluster() {
        GoodsSnapshot record = new GoodsSnapshot();
        record.setOrderId(123);
        record.setName("士大夫");
        record.setPrice(15);
        gsm.insert(record);
        System.out.println( gsm.selectByOrderId(record.getOrderId()).size() );
        return "Hello World cluster";
    }


    @RequestMapping("/t")
    public String clusssster() {
        System.out.println( 11 );
        System.out.println( 11 );
        System.out.println( 11 );
        System.out.println( 11 );
        return "Hello World cluster";
    }

}