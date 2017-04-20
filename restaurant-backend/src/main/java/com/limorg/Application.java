package com.limorg;

import com.mongodb.*;
import org.apache.commons.logging.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.*;

/**
 * Created by gotli01 on 4/3/2017.
 */
@SpringBootApplication
public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "database");
        mongoOps.insert(new Restaurant(422, "LimorVeg",  -74.531250, 28.835050, 10));
        Restaurant one = mongoOps.findOne(new Query(where("name").is("LimorVeg")), Restaurant.class);

        log.info(one);

        mongoOps.dropCollection("person");
    }
}
