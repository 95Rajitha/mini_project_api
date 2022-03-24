package com.example.demo.service;

import com.example.demo.model.CustomerEntity;
import com.example.demo.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Service;

public interface CustomerService {
    /**
     * Adding a user to the user table
     * @param customerEntity
     * @return
     */
    CustomerEntity addCustomer(CustomerEntity customerEntity);
}
