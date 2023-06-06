package com.example.shopmanagerment.service;

import com.example.shopmanagerment.dto.ProductDTO;
import com.example.shopmanagerment.model.Product;

import java.util.List;

public interface ProductService {
    public Product create(ProductDTO productDTO);

    public Product getById(int id);

    public List<Product> getProducts(int page, int limit);

    public Product updateById(int id, ProductDTO productDTO);

    public void deleteById(int id);

    public List<Product> searchByName(String name);
}
