package com.services;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by NEX2UEP on 7/5/2017.
 */
@Service
public class RestfulClient {

    @Autowired
    RestTemplate restTemplate;
}
