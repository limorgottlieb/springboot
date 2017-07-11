package com.datasources;

import com.dtos.Restaurant;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by NEX2UEP on 7/4/2017.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {

    List<Restaurant> findByName(Query query);
}
