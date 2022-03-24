package com.example.demo.dao;

import com.example.demo.model.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Adding a user to the user table
     * @param customerEntity
     * @return
     */
    public CustomerEntity addCustomer(CustomerEntity customerEntity) {
       return customerRepository.save(customerEntity);
    }
}
