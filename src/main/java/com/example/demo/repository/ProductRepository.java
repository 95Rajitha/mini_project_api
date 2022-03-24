package com.example.demo.repository;

import com.example.demo.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {

    @Query(value = "SELECT p FROM ProductEntity p LEFT JOIN CategoryEntity c ON p.categoryEntity.categoryId = c.categoryId where c.categoryName = :category")
    List<ProductEntity> findAllByCategoryName( @Param("category")String category);

    List<ProductEntity> findAllByProductNameLike(String productName);
}
