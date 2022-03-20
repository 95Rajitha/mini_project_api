package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PurchaseQuantity {

    @EmbeddedId
    PurchaseQuantityKey id;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name= "product_id")
    ProductEntity productEntity;


    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name= "cart_id")
    CartEntity cartEntity;


    long purchaseQuantity;


}
