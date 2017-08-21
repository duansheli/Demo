package com.fluffy.dao;

import java.util.List;

import org.bson.BSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.fluffy.entity.User;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

/**
 * 直接将json格式的数据存入mongo中
 */
@Component
public class JsonDao {
    @Autowired
    MongoTemplate mt;
    static final String collectionName = "siteData";

    public int add(DBObject document) {
        if (!mt.collectionExists(collectionName)) {
            // 表不存在则创建
            mt.createCollection(collectionName);
        }
        DBCollection collection = mt.getCollection(collectionName);
        return collection.insert(document).getN();
    }

}