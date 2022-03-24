package com.example.demo.service;

import com.example.demo.model.ProductEntity;

import java.util.List;

public interface PurchaseQuantityService {

    List<ProductEntity> getCartProductEntities(List<Long> purchasedProductIds);
}
