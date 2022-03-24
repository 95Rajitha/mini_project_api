package com.example.demo.controller;

import com.example.demo.exception.EmptyObjectException;
import com.example.demo.model.CartEntity;
import com.example.demo.model.CustomerEntity;
import com.example.demo.model.PurchaseQuantity;
import com.example.demo.restdto.CartRequestDto;
import com.example.demo.restdto.CartResponseDto;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.PurchaseQuantityService;
import com.example.demo.transformers.CartTransformer;
import com.example.demo.transformers.CustomerTransformer;
import com.example.demo.transformers.PurchaseQuatityTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartTransformer cartTransformer;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTransformer customerTransformer;

    @Autowired
    private PurchaseQuantityService purchaseQuantityService;

    @Autowired
    private PurchaseQuatityTransformer purchaseQuatityTransformer;


    /**
     * adding a cart to
     * @param cartRequestDto
     * @return CartResponseDto
     */
    @PostMapping( "/addcart" )
    public ResponseEntity<List<CartResponseDto>> addToCart(@RequestBody CartRequestDto cartRequestDto ){

        if(cartRequestDto == null){
            throw new EmptyObjectException("Cart object is null");
        }
        CustomerEntity customerEntity = customerTransformer.getCustomeEntity(cartRequestDto);
        CustomerEntity customer  = customerService.addCustomer(customerEntity);
//        List<PurchaseQuantity> purchaseQuantityList = purchaseQuatityTransformer.convertToPurchaseQuantity(cartRequestDto);
        if(customer==null){
            log.error("Customer object is null");
            throw  new EmptyObjectException("Customer Object is null");
        }

        List <CartEntity> cartEntityList =cartTransformer.cartEntityTransformation(customer,cartRequestDto);

        cartService.addProcessedCart(cartEntityList);

        List<CartResponseDto> cartResponseDtoList =new ArrayList<>();

        return new ResponseEntity<>( cartResponseDtoList ,HttpStatus.OK );

    }


}
