package com.example.demo.restdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductResponseDto {

    private long productId;
    private String productName;
    private long productPrice;
    private String pictureUrl;
    private String producerInfo;
    private Date manufactureDate;
    private Date expireDate;
    private long numberOfUnits;
    private String productCategory;



}
