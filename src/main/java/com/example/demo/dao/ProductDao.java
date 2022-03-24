package com.example.demo.dao;

import com.example.demo.exception.EmptyListException;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.restdto.ProductRequestDto;
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
     * @return ProductResponseDto
     */
    public List<ProductResponseDto> getAllProducts() throws EmptyListException
    {
        List <ProductEntity> productEntityList =  new ArrayList<>();

        productRepository.findAll().forEach(productEntityList::add);

        if( productEntityList.isEmpty() )
        {
            throw new EmptyListException( "Hotel Table has no data" );
        }

        return productTransformer.convertToProductResponseDtoList(productEntityList);

    }

    /**
     * get products by the specific category
     * @param category
     * @return ProductEntity
     */
    public List<ProductEntity> getProductsInCategory(String category) throws EmptyListException {

        List<ProductEntity> productEntityList = new ArrayList<>();

         productRepository.findAllByCategoryName(category).forEach(productEntityList::add);

         if(productEntityList.isEmpty())
         {
             throw new EmptyListException( "product Table has no data" );
         }

        return productEntityList;

    }

    /**
     * return all the produsts where it contains the matching critera at anyplace of the record
     * @param productRequestDto
     * @return ProductEntity
     * @throws EmptyListException
     */
    public List<ProductEntity> getMatchingProducts(ProductRequestDto productRequestDto) throws EmptyListException {

        List<ProductEntity> productEntityList = new ArrayList<>();

        productRepository.findAllByProductNameLike("%"+productRequestDto.getProductName().trim()+"%").forEach(productEntityList::add);

        if(productEntityList.isEmpty())
        {
            throw new EmptyListException( "product Table has no data" );
        }

        return productEntityList;

    }



}
