package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long productId;

    private String productName;
    private long productPrice;
    private String pictureUrl;
    private String description;





}
