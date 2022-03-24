package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.ProductEntity;
import com.example.demo.service.PurchaseQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseQuantityServiceImpl implements PurchaseQuantityService {

    @Autowired
    private ProductDao productDao;

    public List<ProductEntity> getCartProductEntities(List<Long> purchasedProductIds){
        return  productDao.getCartProductEntities(purchasedProductIds);
    }



}
