package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.restdto.ProductResponseDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<ProductResponseDto> getAllProducts(){
       return productDao.getAllProducts();
   }



}
