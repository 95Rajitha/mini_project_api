package com.example.demo.restdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartInfoDto {
//
//    {
//        items:[{id:0, name: "Cart", cartItems:[] ,subTotal:0}],
//        subTotal:0,
//                totalAmount:0
//    }

    private List<CartItemDto> cartItems;
    private long id;
    private String name;
    private long subTotal;

}
