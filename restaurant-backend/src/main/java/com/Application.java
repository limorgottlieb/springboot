package com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gotli01 on 4/3/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.services"})
public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
