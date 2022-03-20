package com.example.demo.dao;

import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.restdto.ProductResponseDto;
import com.example.demo.transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTransformer productTransformer;


    /**
     * get all th products
     * @return
     */
    public List<ProductResponseDto> getAllProducts() {
        List <ProductEntity> productEntityList =  new ArrayList<>();

        productRepository.findAll().forEach(productEntityList::add);

        return productTransformer.convertToProductResponseDto(productEntityList);

    }
}
