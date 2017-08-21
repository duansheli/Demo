package com.fluffy;

import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.fluffy.dao.JsonDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1_template {

    @Autowired
    JsonDao jsonDao;
    @Autowired
    MongoTemplate mt;

    @Before
    public void setUp() {
        mt.dropCollection("siteData");
        mt.createCollection("siteData");
    }

    @Test
    public void test1() throws Exception {
        String str = "{'name':'peter', 'books':['b1','b2','b3']}";
        String str2 = "{'name':'lily', 'books':['b1','b2','b6','b7']}";
        DBObject parse = (DBObject) com.mongodb.util.JSON.parse(str);
        // add
        int c1 = jsonDao.add(((DBObject) com.mongodb.util.JSON.parse(str)));
        jsonDao.add(((DBObject) com.mongodb.util.JSON.parse(str2)));
        System.out.println(c1);

        DBCollection collection = mt.getCollection("siteData");

        DBObject query = new BasicDBObject("name", Pattern.compile("^pet"));
        DBCursor find = collection.find(query);
        System.out.println("查找name以pet开头的");
        for (DBObject dbObject : find) {
            System.out.println(dbObject);
        }

        DBCursor find2 = collection.find(
                new BasicDBObject().append("name", new BasicDBObject(QueryOperators.NIN, new String[] { "peter" })));
        System.out.println("查找name不包含peter的");
        for (DBObject dbObject : find2) {
            System.out.println(dbObject);
        }

        DBCursor find3 = collection.find(new BasicDBObject("books", "b6"));
        System.out.println("查找books包含b6的");
        for (DBObject dbObject : find3) {
            System.out.println(dbObject);
        }

        DBCursor find4 = collection
                .find(new BasicDBObject("books", new BasicDBObject(QueryOperators.ALL, new String[] { "b6", "b7" })));
        System.out.println("查找books包含b6 b7的");
        for (DBObject dbObject : find4) {
            System.out.println(dbObject);
        }

    }

}
