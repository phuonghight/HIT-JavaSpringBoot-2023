package com.example.shopmanagerment.repository;

import com.example.shopmanagerment.model.Category;
import com.example.shopmanagerment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :#{#newProduct.name}, " +
            "p.description = :#{#newProduct.description}, p.count = :#{#newProduct.count}, " +
            "p.image = :#{#newProduct.image} WHERE p.id = ?1")
    public void updateById(int id, Product newProduct);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    public List<Product> searchByName(String name);
}
