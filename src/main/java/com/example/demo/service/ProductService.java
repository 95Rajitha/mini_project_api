package com.example.demo.service;

import com.example.demo.restdto.ProductResponseDto;

import java.util.List;

public interface ProductService {


    List<ProductResponseDto> getAllProducts();
}
