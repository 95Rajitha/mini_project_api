package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * adding a user to the user table
     * @param customerEntity
     * @return
     */
    public CustomerEntity addCustomer(CustomerEntity customerEntity){

        return customerDao.addCustomer(customerEntity);

    }
}
