package com.example.shopmanagerment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShopManagermentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopManagermentApplication.class, args);
    }

}
