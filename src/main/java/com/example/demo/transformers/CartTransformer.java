package com.example.demo.transformers;

import com.example.demo.model.CartEntity;
import com.example.demo.model.CustomerEntity;
import com.example.demo.model.PurchaseQuantity;
import com.example.demo.restdto.CartInfoDto;
import com.example.demo.restdto.CartItemDto;
import com.example.demo.restdto.CartRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartTransformer {

    @Autowired
    private  PurchaseQuatityTransformer purchaseQuatityTransformer;


    public List<CartEntity> convertToCartEntityList(CustomerEntity customer, CartRequestDto cartRequestDto) {

        List<CartEntity> cartEntityList = new ArrayList<>();


        cartRequestDto.getItems().forEach(cart -> {
            CartEntity cartEntity =  new CartEntity();
            cartEntity.setCartTitle(cart.getName());
            cartEntity.setTotalCost(cart.getSubTotal());
            cartEntity.setCustomerEntity(customer);


            cartEntityList.add(cartEntity);
        });
            return  cartEntityList;
    }



    public List<CartEntity> cartEntityTransformation(CustomerEntity customer, CartRequestDto cartRequestDto) {


        List<CartEntity>cartEntityList = new ArrayList<>();

        for (CartInfoDto cart: cartRequestDto.getItems()) {

            CartEntity cartEntity = new CartEntity();

            cartEntity.setCartTitle(cart.getName());
            cartEntity.setCustomerEntity(customer);
            cartEntity.setTotalCost(cart.getSubTotal());
            cartEntity.setPurchaseQuantityList(purchaseQuatityTransformer.convertToPurchaseQuantity(cart));

            cartEntityList.add(cartEntity);

        }

        return cartEntityList;

    }
}