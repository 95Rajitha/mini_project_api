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
public class CategoryEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long categoryId;

    private String categoryName;
    private String categoryDescription;




}
