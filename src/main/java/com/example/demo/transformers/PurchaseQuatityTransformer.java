package com.example.demo.transformers;

import com.example.demo.model.ProductEntity;
import com.example.demo.model.PurchaseQuantity;
import com.example.demo.restdto.CartInfoDto;
import com.example.demo.restdto.CartItemDto;
import com.example.demo.restdto.CartRequestDto;
import com.example.demo.service.PurchaseQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseQuatityTransformer {

    @Autowired
    private PurchaseQuantityService purchaseQuantityService;

    /**
     * creating purchase entity for the realtionship
     * @param cartInfoDto
     * @return
     */
    public List<PurchaseQuantity> convertToPurchaseQuantity(CartInfoDto cartInfoDto) {


        List<PurchaseQuantity> purchaseQuantityList = new ArrayList<>();

        List<Long> purchasedProductIds = new ArrayList<>();
        cartInfoDto.getCartItems().forEach(item->{
            purchasedProductIds.add(item.getId());
        });

        List <ProductEntity> productEntityList = purchaseQuantityService.getCartProductEntities(purchasedProductIds);
        productEntityList.forEach(productEntity -> {
            PurchaseQuantity purchaseQuantity =  new PurchaseQuantity();
            purchaseQuantity.setProductEntity(productEntity);
            purchaseQuantityList.add(purchaseQuantity);
        });

        List<CartItemDto> cartItemDtoList = cartInfoDto.getCartItems();

        for (PurchaseQuantity purchase:purchaseQuantityList) {

            for (CartItemDto item: cartItemDtoList) {
                    if(purchase.getProductEntity().getProductId() == item.getId()){
                        purchase.setPurchaseQuantity(item.getAmount());
                    }

            }
        }

        return purchaseQuantityList;

    }
}
