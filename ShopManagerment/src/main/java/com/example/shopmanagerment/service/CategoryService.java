package com.example.shopmanagerment.service;

import com.example.shopmanagerment.dto.CategoryDTO;
import com.example.shopmanagerment.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(CategoryDTO categoryDTO);

    public Category getCategoryById(int id);

    public List<Category> getCategories(int page, int limit);

    public Category updateCategoryById(int id, CategoryDTO categoryDTO);

    public void deleteCategoryById(int id);

    public List<Category> searchByName(String name);
}
