package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long productId;

    private String productName;
    private long productPrice;
    private String pictureUrl;
    private String producerInfo;
    private Date manufactureDate;
    private Date expireDate;
    private long numberOfUnits;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryEntity;


//    @Column(nullable = true)
    @OneToMany(mappedBy = "productEntity")
    private List<PurchaseQuantity> purchaseQuantityList;



}
