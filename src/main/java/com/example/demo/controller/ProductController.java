package com.example.demo.controller;

import com.example.demo.restdto.ProductResponseDto;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * get all the hotel
     * @return
     */
    @GetMapping( "/products" )
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){

      List<ProductResponseDto> productResponseDtoList= productService.getAllProducts();
        if( productResponseDtoList.isEmpty() )
        {
            log.warn( "product List is Empty" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        else
        {
            log.info( "Accessed product list" );
            return new ResponseEntity<>( productResponseDtoList, HttpStatus.OK );
        }
    }





}
