package com.services;

import com.datasources.CustomerRepository;
import com.dtos.Customer;
import com.dtos.Restaurant;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by NEX2UEP on 7/5/2017.
 */
@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Customer savecustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomer(String id) {
        return customerRepository.findOne(id);
    }

    public Restaurant insertRestaurant(Restaurant restaurant, String url)
    {
        HttpEntity<Restaurant> request = new HttpEntity<>(new Restaurant());
        ResponseEntity<Restaurant> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Restaurant.class);

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Server error: " + responseEntity.getStatusCodeValue());
        }
    }
}
