package com.controllers;

import com.dtos.Customer;
import com.dtos.Restaurant;
import com.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

/**
 * Created by NEX2UEP on 7/5/2017.
 */
@RestController
@RequestMapping("/customers")
public class CusomerController {

    private static final String RESTAURANT_SERVICE_PATH = "http://localhost:8080/restaurants";
    private static final String RESTAURANT_PATH = "/restaurant";
    private static final String INSERT_RESTAURANT_URL = RESTAURANT_SERVICE_PATH + RESTAURANT_PATH;

    private static final String CUSTOMER_PATH = "/customer";
    private static final String CUSTOMER_GET_PATH = CUSTOMER_PATH + "?" + "id";

    @Autowired
    private CustomerServices customerServices;

    @RequestMapping(method = RequestMethod.POST, path = RESTAURANT_PATH)
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurant) {
        return customerServices.insertRestaurant(restaurant, INSERT_RESTAURANT_URL);
    }

    @RequestMapping(method = RequestMethod.POST, path = CUSTOMER_PATH)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerServices.savecustomer(customer);
    }

    @RequestMapping(method = RequestMethod.POST, path = CUSTOMER_GET_PATH)
    public Customer findCustomer(@RequestParam String id) {
        return customerServices.findCustomer(id);
    }

}
