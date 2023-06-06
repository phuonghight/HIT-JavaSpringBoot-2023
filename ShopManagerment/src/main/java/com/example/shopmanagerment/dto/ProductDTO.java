package com.example.shopmanagerment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Product name is must not null!")
    private String name;

    @Min(value = 0, message = "The quantity is must negative!")
    private int count;

    private MultipartFile image;

    private String description;
}
