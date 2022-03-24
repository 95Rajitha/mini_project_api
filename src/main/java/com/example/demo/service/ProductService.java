package com.example.demo.service;

import com.example.demo.exception.EmptyListException;
import com.example.demo.model.ProductEntity;
import com.example.demo.restdto.ProductRequestDto;
import com.example.demo.restdto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProducts() throws EmptyListException;

    List<ProductEntity> getProductsInCategory(String category) throws EmptyListException;

    List<ProductEntity> getMatchingProducts(ProductRequestDto productRequestDto) throws EmptyListException;
}
