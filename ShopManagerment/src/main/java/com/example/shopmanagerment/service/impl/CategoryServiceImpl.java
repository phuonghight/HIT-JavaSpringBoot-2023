package com.example.shopmanagerment.service.impl;

import com.example.shopmanagerment.dto.CategoryDTO;
import com.example.shopmanagerment.exception.InternalServerException;
import com.example.shopmanagerment.exception.NotFoundException;
import com.example.shopmanagerment.model.Category;
import com.example.shopmanagerment.repository.CategoryRepository;
import com.example.shopmanagerment.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        try {
            Category category = modelMapper.map(categoryDTO, Category.class);
            return categoryRepository.save(category);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Data error creating category");
        }
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id: " + id);
        });
    }

    @Override
    public List<Category> getCategories(int page, int limit) {
        try {
            if(page >= 0 && limit >= 0) {
                return categoryRepository.findAll(PageRequest.of(page, limit)).getContent();
            }
            return categoryRepository.findAll();
        } catch (InternalServerException exception) {
            throw new InternalServerException("Data error finding categories");
        }
    }

    @Override
    public Category updateCategoryById(int id, CategoryDTO categoryDTO) {
        try {
            Category category = modelMapper.map(categoryDTO, Category.class);
            this.getCategoryById(id);
            categoryRepository.updateById(id, category);
            return categoryRepository.findById(id).get();
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error updating category");
        }
    }

    @Override
    public void deleteCategoryById(int id) {
        try {
            this.getCategoryById(id);
            categoryRepository.deleteById(id);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error deleting category");
        }
    }

    @Override
    public List<Category> searchByName(String name) {
        try {
            return categoryRepository.searchByName(name);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error searching category");
        }
    }
}
