package com.example.shopmanagerment.service.impl;

import com.example.shopmanagerment.dto.ProductDTO;
import com.example.shopmanagerment.exception.InternalServerException;
import com.example.shopmanagerment.exception.InvalidException;
import com.example.shopmanagerment.exception.NotFoundException;
import com.example.shopmanagerment.model.Product;
import com.example.shopmanagerment.repository.ProductRepository;
import com.example.shopmanagerment.service.ProductService;
import com.example.shopmanagerment.utils.UploadFileCloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UploadFileCloudinary uploadFileCloudinary;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product create(ProductDTO productDTO) {
        if(productDTO.getImage().isEmpty()) {
            throw new InvalidException("Product image is must not empty!");
        }

        Product product = modelMapper.map(productDTO, Product.class);

        try {
            String imgUrl = uploadFileCloudinary.getUrlFromFile(productDTO.getImage());
            product.setImage(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return productRepository.save(product);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Data error creating product");
        }
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found product with id: " + id);
        });
    }

    @Override
    public List<Product> getProducts(int page, int limit) {
        try {
            if(page >= 0 && limit >= 0) {
                return productRepository.findAll(PageRequest.of(page, limit)).getContent();
            }
            return productRepository.findAll();
        } catch (InternalServerException exception) {
            throw new InternalServerException("Data error finding products");
        }
    }

    @Override
    public Product updateById(int id, ProductDTO productDTO) {
        if(productDTO.getImage().isEmpty()) {
            throw new InvalidException("Product image is must not empty!");
        }

        Product product = this.getById(id);

        try {
            uploadFileCloudinary.removeFileToUrl(product.getImage());
            product.setImage(uploadFileCloudinary.getUrlFromFile(productDTO.getImage()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setName(productDTO.getName());
        product.setCount(productDTO.getCount());
        product.setDescription(productDTO.getDescription());

        try {
            return productRepository.save(product);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error updating product");
        }
    }

    @Override
    public void deleteById(int id) {
        Product product = this.getById(id);

        try {
            uploadFileCloudinary.removeFileToUrl(product.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            productRepository.deleteById(id);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error deleting product");
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        try {
            return productRepository.searchByName(name);
        } catch (InternalServerException exception) {
            throw new InternalServerException("Date error searching product");
        }
    }
}
