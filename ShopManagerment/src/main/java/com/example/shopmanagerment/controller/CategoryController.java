package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.dto.CategoryDTO;
import com.example.shopmanagerment.service.CategoryService;
import com.example.shopmanagerment.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO categoryDTO, BindingResult bindingResult) {
        Validator.propValidator(bindingResult);
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("/auth/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategories(@RequestParam(name = "page", required = false) int page,
                                           @RequestParam(name = "limit", required = false) int limit) {
        return ResponseEntity.ok(categoryService.getCategories(page, limit));
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody @Valid CategoryDTO categoryDTO,
                                            BindingResult bindingResult) {
        Validator.propValidator(bindingResult);
        return ResponseEntity.ok(categoryService.updateCategoryById(id, categoryDTO));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/auth/category/search")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(categoryService.searchByName(name));
    }
}
