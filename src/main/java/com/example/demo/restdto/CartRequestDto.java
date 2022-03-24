package com.example.demo.restdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartRequestDto {

    private List<CartInfoDto> items;
    private String user;
    private String email;
    private long totalCost;
    private List<Long> purchasedProductIds;
    private List<CartItemDto> cartItemDtoList;
}
