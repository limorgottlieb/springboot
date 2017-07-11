package com.datasources;

import com.dtos.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NEX2UEP on 7/5/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
