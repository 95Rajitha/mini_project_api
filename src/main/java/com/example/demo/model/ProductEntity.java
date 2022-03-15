package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
    private String description;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cartEntity;





}
