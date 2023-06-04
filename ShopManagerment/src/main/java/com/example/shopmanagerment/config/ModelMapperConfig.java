package com.example.shopmanagerment.config;

import com.example.shopmanagerment.dto.ProductDTO;
import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.model.Product;
import com.example.shopmanagerment.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        // Tạo object và cấu hình
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(UserDTO.class, User.class).addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {
                skip(destination.getBirthday());
            }
        });


        modelMapper.typeMap(ProductDTO.class, Product.class).addMappings(new PropertyMap<ProductDTO, Product>() {
            @Override
            protected void configure() {
                skip(destination.getImage());
            }
        });
        return modelMapper;
    }
}
