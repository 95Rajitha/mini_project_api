package com.example.demo.transformers;

import com.example.demo.model.CustomerEntity;
import com.example.demo.restdto.CartRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {

    /**
     * Make the customer entity from the request dto
     * @param cartRequestDto
     * @return CustomerEntity
     */
    public CustomerEntity getCustomeEntity(CartRequestDto cartRequestDto) {

        CustomerEntity customerEntity =  new CustomerEntity();
        customerEntity.setCustomerId(cartRequestDto.getEmail());
        customerEntity.setCustomerName(cartRequestDto.getUser());

        return customerEntity;

    }
}
