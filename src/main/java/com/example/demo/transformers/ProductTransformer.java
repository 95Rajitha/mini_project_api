package com.example.demo.transformers;

import com.example.demo.model.ProductEntity;
import com.example.demo.restdto.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTransformer {

    /**
     * method to convert product Entity to producrResponseDtos
     * @param productEntityList
     * @return
     */
    public List<ProductResponseDto> convertToProductResponseDtoList(List<ProductEntity> productEntityList) {

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();


        productEntityList.forEach(productEntity -> {
            ProductResponseDto productResponseDto =  new ProductResponseDto();
            productResponseDto.setProductId(productEntity.getProductId());
            productResponseDto.setProductPrice(productEntity.getProductPrice());
            productResponseDto.setProductName(productEntity.getProductName());
            productResponseDto.setExpireDate(productEntity.getExpireDate());
            productResponseDto.setProducerInfo(productEntity.getProducerInfo());
            productResponseDto.setManufactureDate(productEntity.getManufactureDate());
            productResponseDto.setProductCategory(productEntity.getCategoryEntity().getCategoryName());
            productResponseDtoList.add(productResponseDto);
        });

        return productResponseDtoList;

    }

}
