package com.configuration;

import com.services.RestaurantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Collections;
import java.util.List;


/**
 * Created by gotli01 on 4/3/2017.
 */

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.datasources"})
public class ApplicationConfig extends AbstractCouchbaseConfiguration {
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate;
//    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ValidatingCouchbaseEventListener validationEventListener() {
        return new ValidatingCouchbaseEventListener(validator());
    }

    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList("127.0.0.1");
    }

    @Override
    protected String getBucketName() {
        return "beer-sample";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }
}
