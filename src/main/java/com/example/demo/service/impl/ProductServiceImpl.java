package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.exception.EmptyListException;
import com.example.demo.model.ProductEntity;
import com.example.demo.restdto.ProductRequestDto;
import com.example.demo.restdto.ProductResponseDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * get all the products
     * @return ProductEntity
     */
    public List<ProductEntity> getAllProducts() throws EmptyListException
    {
       return productDao.getAllProducts();
   }

    /**
     * Get products by category
     * @param category
     * @return ProductEntity
     * @throws EmptyListException
     */
   public List<ProductEntity> getProductsInCategory(String category) throws EmptyListException {
        return productDao.getProductsInCategory(category);
   }

    /**
     * get matching products as per the critera
     * @param productRequestDto
     * @return ProductEntity
     */
    public List<ProductEntity> getMatchingProducts(ProductRequestDto productRequestDto) throws EmptyListException {

        return productDao.getMatchingProducts(productRequestDto);
    }




}
