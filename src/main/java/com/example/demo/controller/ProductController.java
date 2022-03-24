package com.example.demo.controller;

import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.EmptyObjectException;
import com.example.demo.model.ProductEntity;
import com.example.demo.restdto.ProductRequestDto;
import com.example.demo.restdto.ProductResponseDto;
import com.example.demo.service.ProductService;
import com.example.demo.transformers.ProductTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTransformer productTransformer;


    /**
     * get all the Products
     * @return ProductEntity
     */
    @GetMapping( "/products" )
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() throws EmptyListException
    {

      List<ProductEntity> productEntityList = productService.getAllProducts();

        List<ProductResponseDto>  productResponseDtoList =productTransformer.convertToProductResponseDtoList(productEntityList);

        if( productResponseDtoList.isEmpty() )
        {
            log.warn( "productResponseDtoList List is Empty" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }else{

            return new ResponseEntity<>( productResponseDtoList ,HttpStatus.OK );

        }

    }

    /**
     *  get all the products related to the requested category
     * @param category
     * @return ProductResponseDto
     * @throws EmptyListException
     */
    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductResponseDto>> getProductsInCategory(@PathVariable String category) throws EmptyListException {

        List<ProductEntity> productEntityList = productService.getProductsInCategory(category.trim());

        if(productEntityList.isEmpty()){
            log.warn( "productEntity List is Empty" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }else
        {
            log.info( "Converting to  productResponseDto");
            List<ProductResponseDto> productResponseDtoList = productTransformer.convertToProductResponseDtoList(productEntityList);
            return  new ResponseEntity<>(productResponseDtoList, HttpStatus.OK );
        }



    }

    /**
     * get matching products related to user search query
     * @param productRequestDto
     * @return ProductResponseDto
     * @throws EmptyObjectException
     */
    @PostMapping("/products/")
    public ResponseEntity<List<ProductResponseDto>> getMatchingProducts(@RequestBody ProductRequestDto productRequestDto) throws EmptyObjectException, EmptyListException {



        if(productRequestDto == null){
            log.error("error:request object is null");
            throw  new EmptyObjectException("Request criteria is null");
        }

        List<ProductEntity> productEntityList = productService.getMatchingProducts(productRequestDto);

        if(productEntityList.isEmpty()){

            log.warn( "product List is Empty" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }else{

           List<ProductResponseDto> productResponseDtoList =  productTransformer.convertToProductResponseDtoList(productEntityList);
            return  new ResponseEntity<>(productResponseDtoList, HttpStatus.OK );
        }

    }



}
