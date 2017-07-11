package com.services;

import com.datasources.RestaurantRepository;
import com.dtos.Restaurant;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by NEX2UEP on 7/4/2017.
 */
@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
