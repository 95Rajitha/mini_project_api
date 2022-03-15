package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long customerId;

    private String customerName;
    private String address;


    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartEntity> cartEntityList;


}
