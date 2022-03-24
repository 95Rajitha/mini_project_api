package com.example.demo.service;

import com.example.demo.model.ProductEntity;

import java.util.List;

public interface PurchaseQuantityService {

    /**
     * get the product entities for a cart
     * @param purchasedProductIds
     * @return ProductEntity
     */
    List<ProductEntity> getCartProductEntities(List<Long> purchasedProductIds);
}
