package com.example.demo.dao;

import com.example.demo.model.CartEntity;
import com.example.demo.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CartDao {

    @Autowired
    private CartRepository cartRepository;

    /**
     * adding dispatched cart to the DB
     * @param cartEntityList
     */
    public void addProcessedCart(List<CartEntity> cartEntityList) {

        cartRepository.saveAll(cartEntityList);


    }
}
