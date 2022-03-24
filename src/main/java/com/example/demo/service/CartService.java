package com.example.demo.service;

import com.example.demo.model.CartEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    void addProcessedCart(List<CartEntity> cartEntityList);
}
