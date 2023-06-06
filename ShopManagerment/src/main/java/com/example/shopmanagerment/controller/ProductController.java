package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.dto.ProductDTO;
import com.example.shopmanagerment.service.ProductService;
import com.example.shopmanagerment.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product",
            consumes = {"multipart/form-data"})
    public ResponseEntity<?> create(@ModelAttribute @Valid ProductDTO productDTO, BindingResult bindingResult) {
        Validator.propValidator(bindingResult);
        return ResponseEntity.ok(productService.create(productDTO));
    }

    @GetMapping("/auth/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/product")
    public ResponseEntity<?> getProducts(@RequestParam(name = "page", required = false) int page,
                                           @RequestParam(name = "limit", required = false) int limit) {
        return ResponseEntity.ok(productService.getProducts(page, limit));
    }

    @PutMapping(value = "/product/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateProduct(@PathVariable int id, @ModelAttribute @Valid ProductDTO productDTO,
                                            BindingResult bindingResult) {
        Validator.propValidator(bindingResult);
        return ResponseEntity.ok(productService.updateById(id, productDTO));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        productService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/auth/product/search")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchByName(name));
    }
}
