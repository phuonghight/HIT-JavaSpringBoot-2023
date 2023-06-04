package com.example.shopmanagerment.repository;

import com.example.shopmanagerment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Category c SET c.name = :#{#newCategory.name}, " +
            "c.description = :#{#newCategory.description} WHERE c.id = ?1")
    public void updateById(int id, Category newCategory);

    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    public List<Category> searchByName(String name);

    public List<Category> findCategoriesByNameContaining(String name);
}
