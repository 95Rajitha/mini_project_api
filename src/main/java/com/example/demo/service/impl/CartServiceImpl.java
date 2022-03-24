package com.example.demo.service.impl;

import com.example.demo.dao.CartDao;
import com.example.demo.model.CartEntity;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    /**
     * adding dispatched cart to the DB
     * @param cartEntityList
     */
    public void addProcessedCart(List<CartEntity> cartEntityList){
        cartDao.addProcessedCart(cartEntityList);
    }

}
