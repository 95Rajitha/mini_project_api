package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart")
public class CartEntity implements Serializable {


    @Id
    @NotNull
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long cartId;

    private String cartStatus;
    private long cartTotal;


    @OneToMany(mappedBy = "cartEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;

}
